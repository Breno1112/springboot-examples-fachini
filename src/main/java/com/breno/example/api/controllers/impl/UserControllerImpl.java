package com.breno.example.api.controllers.impl;

import com.breno.example.api.controllers.UserController;
import com.breno.example.api.dtos.data.MessageResponseDTO;
import com.breno.example.api.dtos.data.UserDTO;
import com.breno.example.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/user/{id}")
    public Mono<UserDTO> getUser(Long id) {
        return Mono.just(this.userService.findUserById(id));
    }

    @Override
    @PostMapping("/user")
    public Mono<UserDTO> addUser(@RequestBody UserDTO body) {
        return Mono.just(this.userService.addUser(body));
    }

    @Override
    @DeleteMapping("/user/{id}")
    public Mono<MessageResponseDTO> deleteUser(Long id) {
        return Mono.just(this.userService.deleteUser(id));
    }

    @Override
    @PutMapping("/user/{id}")
    public Mono<UserDTO> updateUser(Long id, UserDTO body) {
        return Mono.just(this.userService.updateUser(id, body));
    }
}
