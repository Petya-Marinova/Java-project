package com.example.project.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.project.convertor.UserConvertor;
import com.example.project.dto.LoginRequest;
import com.example.project.dto.UserPasswordUpdate;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.entity.User;
import com.example.project.exeption.RecordNotFoundException;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserConvertor userConvertor;
    private final UserRepository userRepository;
    private final BCrypt bCryptPasswordEncoder;
    @Autowired
    public UserServiceImpl(UserConvertor userConvertor, UserRepository userRepository, BCrypt bCryptPasswordEncoder) {
        this.userConvertor = userConvertor;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserResponse addUser(UserRequest user) {
        User userToBeSaved = userConvertor.toUser(new UserRequest());
        userToBeSaved.setPassword(bCryptPasswordEncoder.encode(userToBeSaved.getPassword()));
        return userConvertor.toResponse(userRepository.save(userToBeSaved));

    }

    @Override
    @Transactional
    public void updateUser(UserPasswordUpdate userPasswordUpdate) throws RecordNotFoundException {
        Optional<User> user = userRepository.findById(userPasswordUpdate.getId());
        if(user.isEmpty()){
            throw  new RecordNotFoundException("User not found or invalid credentials");
        } else {
            user.get().setPassword(userPasswordUpdate.getNewPassword());
        }

    }

    @Override
    public Optional<User> getById(Long id)  {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
            userRepository.deleteById(id);

    }

    @Override
    public UserResponse login(LoginRequest loginRequest) throws RecordNotFoundException {
        Optional<User> searchedUser = userRepository.findByEmail(loginRequest.getEmail());
        if (searchedUser.isEmpty()) {
            throw new RecordNotFoundException("User not found or invalid credentials");
        }
        return userConvertor.toResponse(searchedUser.get());
    }
    @Override
    public User findByEmail(String email) throws RecordNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->new RecordNotFoundException("User not found"));
    }

    @Override
    public UserResponse getUser(Long id) throws RecordNotFoundException {
        return userConvertor.toResponse(userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Id %s not found", id))));
    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
