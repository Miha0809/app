package com.slamy.app.controllers;

import com.slamy.app.interfaces.IUser;
import com.slamy.app.models.User;
import com.slamy.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/authentication")
public class AuthenticationController {
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public IUser register(@RequestBody User user) {
        this.userRepository.save(user);
        return user;
    }
}
