package com.example.springdemo.hello;

import java.util.UUID;

public class UserDto {

    private UUID userID;
    private String userName;
    private String userAge;

    public UserDto(String userName, String userAge) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.userAge = userAge;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }
}
