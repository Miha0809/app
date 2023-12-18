package com.slamy.app.repositories;

import com.slamy.app.interfaces.IEmail;
import com.slamy.app.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(IEmail email);
    List<User> findAll();
}
