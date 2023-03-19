package com.example.project.repository;

import com.example.project.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);
}
