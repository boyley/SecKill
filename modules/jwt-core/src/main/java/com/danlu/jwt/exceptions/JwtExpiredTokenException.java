package com.danlu.jwt.exceptions;


import com.danlu.jwt.security.model.token.JwtToken;

/**
 * @author vladimir.stankovic
 *         <p>
 *         Aug 3, 2016
 */
public class JwtExpiredTokenException extends RuntimeException {
    private static final long serialVersionUID = -5959543783324224864L;

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
