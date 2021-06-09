package com.breno.example.graphql.services.impl;

import com.breno.example.graphql.domain.entities.UserEntity;
import com.breno.example.graphql.domain.repositories.UserRepository;
import com.breno.example.graphql.exceptions.UserNotFoundException;
import com.breno.example.graphql.mappers.UserMapper;
import com.breno.example.graphql.services.UserService;
import com.breno.example.graphql.types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserType findUserById(String id) {
        return this.userRepository.findById(Long.parseLong(id)).map(value -> userMapper.fromUserEntityToType(value)).orElse(new UserType(""));
    }

    @Override
    public UserType addUser(UserType body) {
        return this.userMapper.fromUserEntityToType(this.userRepository.saveAndFlush(this.userMapper.fromUserTypeToUserEntity(body)));
    }

    @Override
    public void deleteUser(String id) {
        final Optional<UserEntity> optionalUserEntity = this.userRepository.findById(Long.parseLong(id));
        if(optionalUserEntity.isPresent()){
            this.userRepository.delete(optionalUserEntity.get());
            return;
        }
        throw new UserNotFoundException();
    }

    @Override
    public UserType updateUser(String id, UserType body) {
        return this.userMapper.fromUserEntityToType(this.userRepository.saveAndFlush(this.userMapper.dynamicUserTypeToEntity(body, this.userRepository.findById(Long.parseLong(id)).orElse(null))));
    }
}
