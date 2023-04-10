package com.appreeze.userservice.services;

import com.appreeze.userservice.model.User;
import com.appreeze.userservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final ProductRepository userRepo;

    public User searchUser(String id) {
        return userRepo.findByUserId(id);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }
}
