package com.example.springdemo.todo.adapter.persistence;

import com.example.springdemo.todo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepository {
    private final Map<Long, Todo> todoMap = new HashMap<>();

    public Todo save(Todo todo) {
        todoMap.put(todo.getId(), todo);

        return todoMap.get(todo.getId());
    }

    public Todo findById(long id) {
        return todoMap.get(id);
    }

    public Map<Long, Todo> findAll() {
        return todoMap;
    }
}
