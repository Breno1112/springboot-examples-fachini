package com.breno.example.api.services.impl;

import com.breno.example.api.domain.entities.UserEntity;
import com.breno.example.api.domain.repositories.UserRepository;
import com.breno.example.api.dtos.UserDTO;
import com.breno.example.api.mappers.UserMapper;
import com.breno.example.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findUserById(Long id) {
        return this.userRepository.findById(id).map(value -> userMapper.fromUserEntityToDTO(value)).orElse(new UserDTO());
    }

    @Override
    public UserDTO addUser(UserDTO body) {
        return this.userMapper.fromUserEntityToDTO(this.userRepository.saveAndFlush(this.userMapper.fromUserDTOToUserEntity(body)));
    }
}
