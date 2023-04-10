package com.appreeze.userservice.controllers;

import com.appreeze.userservice.model.User;
import com.appreeze.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{customerNumber}")
    @PreAuthorize("hasPermission(#customerNumber, 'read:user')")
    public ResponseEntity<User> searchUser(@PathVariable("customerNumber") String customerNumber) {
        return new ResponseEntity<>(userService.searchUser(customerNumber), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasPermission('customerNumber', 'create:user')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}