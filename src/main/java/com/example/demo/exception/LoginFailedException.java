package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class LoginFailedException extends RuntimeException {

    public LoginFailedException() {
        super("Invalid login ID or password.");
    }
}
