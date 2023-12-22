package com.slamy.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.slamy.app.models.Email;

public interface EmailRepository extends CrudRepository<Email, Long> {
    boolean existsByEmail(String email);
    Email findByEmail(String email);

}
