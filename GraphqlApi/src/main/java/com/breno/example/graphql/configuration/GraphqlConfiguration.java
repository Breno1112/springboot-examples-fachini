package com.breno.example.graphql.configuration;

import com.breno.example.graphql.types.resolvers.UserQueryResolver;
import com.breno.example.graphql.types.resolvers.UserTypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public UserQueryResolver getUserQueryResolver(){
        return new UserQueryResolver();
    }

    @Bean
    public UserTypeResolver getUserTypeResolver(){
        return new UserTypeResolver();
    }
}
