package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.LoginFailedException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.form.AccountLoginForm;
import com.example.demo.service.UserService;
import com.example.demo.view.LoginView;

@RestController
public class UserController {
	@Autowired
    private UserService service;

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable String id) throws UserNotFoundException {
        UserDto user = service.getUser(id);

        if(user == null)
            throw new UserNotFoundException(id);

        return user;
    }

    
    @PostMapping("/users/accounts")
    public UserDto createUserWithAccount(@RequestBody UserDto form) {
        return service.createUserWithAccount(form);
    }

    @PostMapping("/users/accounts/tokens")
    public LoginView createToken(@RequestBody AccountLoginForm form) {
    	UserDto user = service.getAccountUser(form.getId(), form.getPassword());

        if(user == null)
            throw new LoginFailedException();

        LoginView view = new LoginView();
        view.setUserId(user.getId());
        view.setToken(service.createLoginToken(user.getId()));
        return view;
    }
}
