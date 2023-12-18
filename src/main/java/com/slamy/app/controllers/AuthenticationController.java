package com.slamy.app.controllers;

import com.slamy.app.interfaces.IUser;
import com.slamy.app.models.Email;
import com.slamy.app.models.Login;
import com.slamy.app.models.User;
import com.slamy.app.repositories.EmailRepository;
import com.slamy.app.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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
    public IUser register(@NotNull @RequestBody User user) {
        this.emailRepository.save(user.getEmail());
        this.userRepository.save(user);
        return user;
    }

    @PostMapping("/login")
    public boolean login(@NotNull @RequestBody Login login) {
        if (this.emailRepository.findEmailBy(login.getEmail()) != null) {
            User user = this.userRepository.findUserByEmail(login.getEmail());
            user.setIsLoggedIn(true);
            this.userRepository.save(user);

            return true;
        }

        return false;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
