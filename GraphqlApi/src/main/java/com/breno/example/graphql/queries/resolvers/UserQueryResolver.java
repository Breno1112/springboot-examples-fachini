package com.breno.example.graphql.queries.resolvers;

import com.breno.example.graphql.services.UserService;
import com.breno.example.graphql.types.UserType;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class UserQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public UserType getUser(@NotNull String id){
        return this.userService.findUserById(id);
    }
}
