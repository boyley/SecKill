package com.danlu.jwt.exceptions;

/**
 * Created by lenovo on 2017/6/19.
 */
public class BadCredentialsException extends RuntimeException {
    public BadCredentialsException(String msg) {
        super(msg);
    }

    public BadCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }
}