package com.breno.example.api.services.impl;

import com.breno.example.api.domain.entities.UserEntity;
import com.breno.example.api.domain.repositories.UserRepository;
import com.breno.example.api.dtos.data.MessageResponseDTO;
import com.breno.example.api.dtos.data.UserDTO;
import com.breno.example.api.dtos.exceptions.UserNotFoundException;
import com.breno.example.api.enums.OutputMessageEnum;
import com.breno.example.api.mappers.UserMapper;
import com.breno.example.api.services.UserService;
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
    public UserDTO findUserById(Long id) {
        return this.userRepository.findById(id).map(value -> userMapper.fromUserEntityToDTO(value)).orElse(new UserDTO());
    }

    @Override
    public UserDTO addUser(UserDTO body) {
        return this.userMapper.fromUserEntityToDTO(this.userRepository.saveAndFlush(this.userMapper.fromUserDTOToUserEntity(body)));
    }

    @Override
    public MessageResponseDTO deleteUser(Long id) {
        final Optional<UserEntity> optionalUserEntity = this.userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            this.userRepository.delete(optionalUserEntity.get());
            final MessageResponseDTO toReturn = new MessageResponseDTO();
            toReturn.setOutputMessage(OutputMessageEnum.USER_DELETED);
            return toReturn;
        }
        throw new UserNotFoundException();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO body) {
        return this.userMapper.fromUserEntityToDTO(this.userRepository.saveAndFlush(this.userMapper.dynamicUserDTOToEntity(body, this.userRepository.findById(id).orElse(null))));
    }
}
