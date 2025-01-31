package com.example.springdemo.hello;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserEntityRepository implements EntityRepository<UserDto> {

    Map<UUID, UserDto> map = new HashMap<>();

    @Override
    public void save(UserDto userDto) {
        map.put(userDto.getUserID(), userDto);
    }

    @Override
    public UserDto fetchData(String name) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().getUserName().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Map<UUID, UserDto> fetchAllData() {
        return map;
    }
}
