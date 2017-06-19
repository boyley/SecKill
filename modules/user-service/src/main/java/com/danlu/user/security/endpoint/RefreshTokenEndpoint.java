package com.danlu.user.security.endpoint;

import com.danlu.jwt.config.JwtSettings;
import com.danlu.jwt.security.model.UserContext;
import com.danlu.jwt.security.model.token.JwtToken;
import com.danlu.jwt.security.model.token.JwtTokenFactory;
import com.danlu.jwt.security.model.token.RawAccessJwtToken;
import com.danlu.jwt.security.model.token.RefreshToken;
import com.danlu.jwt.extractor.TokenExtractor;
import com.danlu.jwt.verifier.TokenVerifier;
import com.danlu.user.security.config.SecurityConfiguration;
import com.danlu.jwt.exceptions.InvalidJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * RefreshTokenEndpoint
 *
 * @author vladimir.stankovic
 *         <p>
 *         Aug 17, 2016
 */
@RestController
public class RefreshTokenEndpoint {
    @Autowired
    private JwtTokenFactory tokenFactory;
    @Autowired
    private JwtSettings jwtSettings;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenVerifier tokenVerifier;
    @Autowired
    @Qualifier("jwtHeaderTokenExtractor")
    private TokenExtractor tokenExtractor;

    @RequestMapping(value = "/api/auth/token", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(SecurityConfiguration.JWT_TOKEN_HEADER_PARAM));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        UserDetails user = userDetailsService.loadUserByUsername(subject);

        if (user.getAuthorities() == null) throw new InsufficientAuthenticationException("User has no roles assigned");

        UserContext userContext = UserContext.create(user.getUsername(), user.getAuthorities().stream().map(s -> s.getAuthority()).collect(Collectors.toList()));

        return tokenFactory.createAccessJwtToken(userContext);
    }
}
