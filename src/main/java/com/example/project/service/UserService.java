package com.example.project.service;

import com.example.project.dto.LoginRequest;
import com.example.project.dto.UserPasswordUpdate;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.entity.User;
import com.example.project.exeption.RecordNotFoundException;

import java.util.Optional;

public interface UserService {


    UserResponse addUser(UserRequest user);

    void updateUser(UserPasswordUpdate client) throws RecordNotFoundException;
    Optional<User> getById(Long id);
    void deleteUser(Long id);
    UserResponse login(LoginRequest loginRequest) throws RecordNotFoundException;
    User findByEmail(String email) throws RecordNotFoundException;
    UserResponse getUser(Long id) throws RecordNotFoundException;

    User addUser(User user);
}
