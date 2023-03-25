package com.appreeze.userservice.controllers;

import com.appreeze.userservice.model.Message;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping(value = "/{customerNumber}")
    @PreAuthorize("hasPermission(#customerNumber, 'read:user')")
    public Message privateScopedEndpoint(@PathVariable("customerNumber") String customerNumber) {
        return new Message("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
    }
}