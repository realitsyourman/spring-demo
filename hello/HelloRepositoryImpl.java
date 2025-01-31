package com.example.springdemo.hello;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {
    @Override
    public String fetchData() {
        return "hello form repository";
    }
}
