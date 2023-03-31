package com.appreeze.userservice.controllers;

import com.appreeze.userservice.model.User;
import com.appreeze.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{customerNumber}")
    @PreAuthorize("hasPermission(#customerNumber, 'read:user')")
    public User privateScopedEndpoint(@PathVariable("customerNumber") String customerNumber) {
        return userService.getUserById(customerNumber);
    }
}