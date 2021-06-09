package com.breno.example.graphql.mappers.impl;

import com.breno.example.graphql.domain.entities.UserEntity;
import com.breno.example.graphql.exceptions.UserNotFoundException;
import com.breno.example.graphql.mappers.UserMapper;
import com.breno.example.graphql.types.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserType fromUserEntityToType(UserEntity userEntity) {
        final UserType toReturn = new UserType(userEntity.getId().toString());
        toReturn.setId(userEntity.getId().toString());
        toReturn.setAge(userEntity.getAge());
        toReturn.setFirstName(userEntity.getFirstName());
        toReturn.setMiddleName(userEntity.getMiddleName());
        toReturn.setLastName(userEntity.getLastName());
        return toReturn;
    }

    @Override
    public UserEntity fromUserTypeToUserEntity(UserType userType) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userType.getFirstName());
        userEntity.setMiddleName(userType.getMiddleName());
        userEntity.setLastName(userType.getLastName());
        userEntity.setAge(userType.getAge());
        return userEntity;
    }

    @Override
    public UserEntity dynamicUserTypeToEntity(UserType userType, UserEntity userEntity) {
        if(userEntity == null){
            throw new UserNotFoundException();
        }
        if (userType.getFirstName() != null){
            userEntity.setFirstName(userType.getFirstName());
        }
        if(userType.getMiddleName() != null){
            userEntity.setMiddleName(userType.getMiddleName());
        }
        if(userType.getLastName() != null){
            userEntity.setLastName(userType.getLastName());
        }
        if(userType.getAge() != null){
            userEntity.setAge(userType.getAge());
        }
        return userEntity;
    }
}
