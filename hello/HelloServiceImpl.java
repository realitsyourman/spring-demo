package com.example.springdemo.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    private final HelloRepository helloRepository;

    public HelloServiceImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String getHelloMessage() {
        return "Service says : " + helloRepository.fetchData();
    }
}
