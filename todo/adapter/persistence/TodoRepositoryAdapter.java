package com.example.springdemo.todo.adapter.persistence;


import com.example.springdemo.todo.domain.Todo;
import com.example.springdemo.todo.domain.TodoCommand;
import com.example.springdemo.todo.domain.TodoResult;
import com.example.springdemo.todo.port.TodoRepositoryPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
class TodoRepositoryAdapter implements TodoRepositoryPort {
    private final TodoRepository todoRepository;
    private int todoId = 1;

    public TodoRepositoryAdapter(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResult save(TodoCommand command) {
        Todo todo = convertToTodo(command);
        Todo savedTodo = todoRepository.save(todo);
        return convertToDto(savedTodo);
    }

    @Override
    public TodoResult findById(long id) {
        Todo todo = todoRepository.findById(id);
        return todo != null ? convertToDto(todo) : null;
    }

    @Override
    public Map<Long, TodoResult> findAll() {
        return todoRepository.findAll()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> convertToDto(entry.getValue())
                ));
    }

    private Todo convertToTodo(TodoCommand command) {
        return new Todo(todoId++, command.title(), command.content());
    }

    private TodoResult convertToDto(Todo todo) {
        return new TodoResult(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                LocalDateTime.now()
        );
    }
}

