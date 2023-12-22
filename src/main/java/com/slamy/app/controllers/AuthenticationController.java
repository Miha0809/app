package com.slamy.app.controllers;

import com.slamy.app.interfaces.IUser;
import com.slamy.app.models.Email;
import com.slamy.app.models.Login;
import com.slamy.app.models.User;
import com.slamy.app.repositories.EmailRepository;
import com.slamy.app.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/authentication")
public class AuthenticationController {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository,
                                    EmailRepository emailRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
    }

    @PostMapping("/register")
    public IUser register(@RequestBody User user) {
        if (user.getEmail() != null) {
            this.emailRepository.save(user.getEmail());
            this.userRepository.save(user);
        }

        return user;
    }

    private User user = null;
    private Email email = null;

    @PostMapping("/login")
    public boolean login(@RequestBody Login login) {
        if (this.emailRepository.existsByEmail(login.getEmail().getEmail())) {
            this.email = this.emailRepository.findByEmail(login.getEmail().getEmail());
            this.user = this.userRepository.findUserByEmail(email);

            this.user.setIsLoggedIn(true);
            this.userRepository.save(this.user);
        }

        return this.userRepository.findUserByEmail(this.emailRepository.findByEmail(login.getEmail().getEmail())).getIsLoggedIn();
    }

    @GetMapping("/logout")
    public boolean getUsers() {
        if (this.user.getIsLoggedIn()) {
            this.user.setIsLoggedIn(false);
            this.userRepository.save(this.user);
        }

        return this.userRepository.findUserByEmail(this.emailRepository.findByEmail(this.email.getEmail())).getIsLoggedIn();
    }
}
