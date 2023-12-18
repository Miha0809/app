package com.slamy.app.repositories;

import com.slamy.app.models.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findEmailBy(Email email);
}
