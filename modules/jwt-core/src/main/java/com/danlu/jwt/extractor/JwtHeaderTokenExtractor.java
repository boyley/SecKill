package com.danlu.jwt.extractor;

import com.danlu.jwt.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * An implementation of {@link TokenExtractor} extracts token from
 * Authorization: Bearer scheme.
 *
 * @author vladimir.stankovic
 *         <p>
 *         Aug 5, 2016
 */
@Component
public class JwtHeaderTokenExtractor implements TokenExtractor {
    public static String HEADER_PREFIX = "Bearer ";

    @Override
    public String extract(String header) {
        if (StringUtils.isBlank(header)) {
            throw new RuntimeException("Authorization header cannot be blank!");
        }

        if (header.length() < HEADER_PREFIX.length()) {
            throw new RuntimeException("Invalid authorization header size.");
        }

        return header.substring(HEADER_PREFIX.length(), header.length());
    }
}
