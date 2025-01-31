package com.example.springdemo.todo.adapter.persistence;


import com.example.springdemo.todo.domain.Todo;
import com.example.springdemo.todo.domain.TodoCommand;
import com.example.springdemo.todo.domain.TodoResult;
import com.example.springdemo.todo.port.EntityRepositoryPort;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Repository
public class TodoRepositoryAdapter implements EntityRepositoryPort<Todo> {
    private final TodoRepository todoRepository;
    int todoId = 1;

    @Autowired
    public TodoRepositoryAdapter(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResult save(TodoCommand todo) {
        Todo newTodo = convertToTodo(todo);
        Todo savedTodo = todoRepository.save(newTodo);

        TodoResult todoResult = new TodoResult(newTodo.getId(),
                newTodo.getTitle(),
                newTodo.getContent(),
                newTodo.getDate());

        return todoResult;
    }

    @Override
    public TodoResult findById(long id) {
        Todo byId = todoRepository.findById(id);
        if (byId == null) {
            return null;
        }
        return convertToDto(byId);
    }

    @Override
    public Map<Long, TodoResult> findAll() {
        Map<Long, Todo> allTodos = todoRepository.findAll();

        Map<Long, TodoResult> collect = allTodos.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> convertToDto(entry.getValue())
                ));

        return collect;
    }

    public Todo convertToTodo(TodoCommand todo) {
        return new Todo(todoId++, todo.title(), todo.content());
    }

    public TodoResult convertToDto(Todo todo) {
        return new TodoResult(todo.getId(), todo.getTitle(), todo.getContent(), LocalDateTime.now());
    }
}

