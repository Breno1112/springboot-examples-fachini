package com.breno.example.graphql.mutations.resolvers;

import com.breno.example.graphql.mappers.UserMapper;
import com.breno.example.graphql.services.UserService;
import com.breno.example.graphql.types.UserInput;
import com.breno.example.graphql.types.UserType;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMutationsResolver implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    public UserType addUser(UserInput userInput){
        return this.userService.addUser(this.userMapper.fromUserInputToUserType(userInput));
    }
}
