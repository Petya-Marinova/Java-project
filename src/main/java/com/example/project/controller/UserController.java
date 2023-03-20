package com.example.project.controller;

import com.example.project.convertor.UserConvertor;
import com.example.project.dto.LoginRequest;
import com.example.project.dto.UserPasswordUpdate;
import com.example.project.dto.UserResponse;
import com.example.project.entity.User;
import com.example.project.exeption.RecordNotFoundException;
import com.example.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserConvertor userConvertor;


 //   @PostMapping
  //  ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest) throws RecordNotFoundException {
  //      return ResponseEntity
 //               .status(HttpStatus.CREATED)
   //             .body(userService.saveUser(userRequest));
  //  }

    @PostMapping(path = "/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @PostMapping(path = "/login")
    ResponseEntity<UserResponse> login(@RequestBody @Valid LoginRequest loginRequest) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.login(loginRequest));
    }

    @PutMapping(path = "/password")
    ResponseEntity<String> updateUser(@RequestBody @Valid UserPasswordUpdate user) throws RecordNotFoundException {
        userService.updateUser(user);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Password changed");
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<UserResponse> getUser(@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userService.getUser(id));
    }
    @GetMapping(path = "/email")
    ResponseEntity<User> findByEmail(@PathVariable String email) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userService.findByEmail(email));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity
                .ok()
                .body(String.format("%d deleted", id));
    }
}
