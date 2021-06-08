package com.breno.example.api.mappers.impl;

import com.breno.example.api.domain.entities.UserEntity;
import com.breno.example.api.dtos.UserDTO;
import com.breno.example.api.mappers.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO fromUserEntityToDTO(UserEntity userEntity) {
        final UserDTO toReturn = new UserDTO();
        toReturn.setId(userEntity.getId());
        toReturn.setAge(userEntity.getAge());
        toReturn.setFirstName(userEntity.getFirstName());
        toReturn.setMiddleName(userEntity.getMiddleName());
        toReturn.setLastName(userEntity.getLastName());
        return toReturn;
    }

    @Override
    public UserEntity fromUserDTOToUserEntity(UserDTO userDTO) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setMiddleName(userDTO.getMiddleName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setAge(userDTO.getAge());
        return userEntity;
    }
}
