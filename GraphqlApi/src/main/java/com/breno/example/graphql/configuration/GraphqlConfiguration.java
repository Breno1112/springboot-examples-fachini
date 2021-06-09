package com.breno.example.graphql.configuration;

import com.breno.example.graphql.mutations.resolvers.UserMutationsResolver;
import com.breno.example.graphql.queries.resolvers.UserQueriesResolver;
import com.breno.example.graphql.types.resolvers.UserTypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public UserQueriesResolver getUserQueriesResolver(){
        return new UserQueriesResolver();
    }

    @Bean
    public UserTypeResolver getUserTypeResolver(){
        return new UserTypeResolver();
    }

    @Bean
    public UserMutationsResolver getUserMutationsResolver(){
        return new UserMutationsResolver();
    }
}
