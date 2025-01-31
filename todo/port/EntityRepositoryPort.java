package com.example.springdemo.todo.port;

import java.util.Map;

public interface EntityRepositoryPort<T> {
    T save(T todo);

    T findById(long id);

    Map<Long, T> findAll();
}
