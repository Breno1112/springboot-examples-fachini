package com.breno.example.api.controllers;

import com.breno.example.api.dtos.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


public interface UserController {

    String NOT_IMPLEMENTED_EXCEPTION_MESSAGE = "Not Implemented";


    default Mono<UserDTO> getUser(@PathVariable("id") Long id){
        throw new RuntimeException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
    }
}
