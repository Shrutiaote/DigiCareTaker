package com.digicaretaker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.digicaretaker.entity.User;
import com.digicaretaker.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {

        return userService
                .loginUser(user.getEmail(), user.getPassword())
                .orElse(null);
    }
}