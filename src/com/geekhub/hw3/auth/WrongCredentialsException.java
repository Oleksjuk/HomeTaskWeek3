package com.geekhub.hw3.auth;

public class WrongCredentialsException extends AuthException {
    public WrongCredentialsException(String message) {
        super(message);
    }
}
