package com.breno.example.graphql.types.resolvers;

import com.breno.example.graphql.types.UserType;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class UserQueryResolver implements GraphQLQueryResolver {

    public UserType getUser(String id){
        return new UserType();
    }
}
