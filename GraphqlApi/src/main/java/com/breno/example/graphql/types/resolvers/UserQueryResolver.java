package com.breno.example.graphql.types.resolvers;

import com.breno.example.graphql.types.UserType;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.jetbrains.annotations.NotNull;

public class UserQueryResolver implements GraphQLQueryResolver {

    public UserType getUser(@NotNull String id){
        return new UserType(id);
    }
}
