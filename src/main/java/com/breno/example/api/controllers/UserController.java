package com.breno.example.api.controllers;

import com.breno.example.api.dtos.data.MessageResponseDTO;
import com.breno.example.api.dtos.data.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;


public interface UserController {

    String NOT_IMPLEMENTED_EXCEPTION_MESSAGE = "Not Implemented";


    default Mono<UserDTO> getUser(@PathVariable("id") Long id){
        throw new RuntimeException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
    }

    default Mono<UserDTO> addUser(UserDTO body){
        throw new RuntimeException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
    }

    default Mono<MessageResponseDTO> deleteUser(@PathVariable("id") Long id){
        throw new RuntimeException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
    }

    default Mono<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO body){
        throw new RuntimeException(NOT_IMPLEMENTED_EXCEPTION_MESSAGE);
    }
}
