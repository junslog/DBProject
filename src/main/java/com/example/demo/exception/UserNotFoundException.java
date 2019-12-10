package com.example.demo.exception;

import org.apache.ibatis.javassist.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(long userId) {
        super("Cannot find user ID '" + userId + "'.");
    }

    public UserNotFoundException(String loginId) {
        super("Cannot find user ID '" + loginId + "'.");
    }

}