package com.example.springdemo.hello;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    private final EntityRepository<UserDto> entityRepository;

    public HelloController(HelloService helloService, EntityRepository<UserDto> entityRepository) {
        this.helloService = helloService;
        this.entityRepository = entityRepository;
    }

    @GetMapping("/world")
    public String helloWorld() {
        return helloService.getHelloMessage();
    }

    @PostMapping("/user")
    public String saveUser(@RequestBody UserDto user) {
        entityRepository.save(user);

        return "저장완료";
    }

    @GetMapping("/name/{name}")
    public UserDto getUserByName(@PathVariable String name) {
        return (UserDto) entityRepository.fetchData(name);
    }

    @GetMapping("/name")
    public Map<UUID, UserDto> getAllUsers() {
        return entityRepository.fetchAllData();
    }
}
