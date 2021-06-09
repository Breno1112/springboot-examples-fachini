package com.breno.example.graphql.mappers;


import com.breno.example.graphql.domain.entities.UserEntity;
import com.breno.example.graphql.types.UserType;

public interface UserMapper {

    String USER_MAPPER_NOT_IMPLEMENTED_MESSAGE = "User mapper not implemented";

    default UserType fromUserEntityToType(UserEntity userEntity){
        throw new RuntimeException(USER_MAPPER_NOT_IMPLEMENTED_MESSAGE);
    }

    default UserEntity fromUserTypeToUserEntity(UserType userType){
        throw new RuntimeException(USER_MAPPER_NOT_IMPLEMENTED_MESSAGE);
    }

    default UserEntity dynamicUserTypeToEntity(UserType userType, UserEntity userEntity){
        throw new RuntimeException(USER_MAPPER_NOT_IMPLEMENTED_MESSAGE);
    }
}
