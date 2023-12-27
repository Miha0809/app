package com.slamy.app.repositories;

import com.slamy.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
//    User findUserByIsLoggedIn(boolean isLoggedIn);
//    User findUserByIsLoggedIn(boolean isLoggedIn);
    List<User> findAll();
    User findUserByFirstNameAndLastName(String firstname, String lastName);

    Optional<User> findByEmail(String email);
}
