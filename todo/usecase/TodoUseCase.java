package com.example.springdemo.todo.usecase;

import com.example.springdemo.todo.domain.TodoCommand;
import com.example.springdemo.todo.domain.TodoResult;

import java.util.Map;

public interface TodoUseCase {
    TodoResult write(TodoCommand todoCommand);

    Map<Long, String> getTitleList();

    TodoResult readTodo(long id);

    TodoResult findById(long id);

    Map<Long, TodoResult> findAll();
}
