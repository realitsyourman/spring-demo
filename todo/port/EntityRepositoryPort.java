package com.example.springdemo.todo.port;

import com.example.springdemo.todo.domain.TodoCommand;
import com.example.springdemo.todo.domain.TodoResult;

import java.util.Map;

public interface EntityRepositoryPort<T> {
    TodoResult save(TodoCommand todo);

    TodoResult findById(long id);

    Map<Long, TodoResult> findAll();
}
