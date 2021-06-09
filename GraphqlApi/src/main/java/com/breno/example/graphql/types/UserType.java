package com.breno.example.graphql.types;

public class UserType {

    private String id;

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer age;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
