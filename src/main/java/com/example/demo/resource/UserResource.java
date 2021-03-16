package com.example.demo.resource;

import com.example.demo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("user/")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {// TODO: 3/16/2021 encrypt password
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/login") // TODO: 3/16/2021 authorization resourse 
    public HttpEntity<Boolean> validateUser  (@RequestBody User user) {
        boolean validated = userService.validateUser();
        return new ResponseEntity<Boolean>(validated, HttpStatus.OK);
    }
}