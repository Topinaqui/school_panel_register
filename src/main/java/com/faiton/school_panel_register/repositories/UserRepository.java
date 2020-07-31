package com.faiton.school_panel_register.repositories;

import java.util.Optional;

import com.faiton.school_panel_register.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);

}