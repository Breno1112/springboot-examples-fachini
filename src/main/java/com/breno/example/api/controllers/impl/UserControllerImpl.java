package com.breno.example.api.controllers.impl;

import com.breno.example.api.controllers.UserController;
import com.breno.example.api.dtos.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    @GetMapping("/users/{id}")
    public Mono<UserDTO> getUser(Long id) {
        return Mono.just(new UserDTO());
    }
}
