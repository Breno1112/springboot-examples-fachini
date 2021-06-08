package com.breno.example.api.controllers.impl;

import com.breno.example.api.controllers.UserController;
import com.breno.example.api.dtos.UserDTO;
import com.breno.example.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/users/{id}")
    public Mono<UserDTO> getUser(Long id) {
        return Mono.just(this.userService.findUserById(id));
    }

    @Override
    @PostMapping("/user")
    public Mono<UserDTO> addUser(@RequestBody UserDTO body) {
        return Mono.just(this.userService.addUser(body));
    }
}
