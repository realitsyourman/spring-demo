package com.example.springdemo.hello;

import java.util.Map;
import java.util.UUID;

public interface EntityRepository<T> {
    void save(T t);

    T fetchData(String name);

    Map<UUID, T> fetchAllData();
}
