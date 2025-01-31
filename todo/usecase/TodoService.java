package com.example.springdemo.todo.usecase;

import com.example.springdemo.todo.domain.TodoCommand;
import com.example.springdemo.todo.domain.TodoResult;
import com.example.springdemo.todo.port.TodoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TodoService implements TodoUseCase {
    private final TodoRepositoryPort todoRepository;

    @Autowired
    public TodoService(TodoRepositoryPort todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 글쓰기
    public TodoResult write(TodoCommand todoCommand) {
        return todoRepository.save(todoCommand);
    }

    // 제목 리스트 뽑기
    public Map<Long, String> getTitleList() {
        Map<Long, TodoResult> allTodos = findAll();

        return allTodos.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().title()
                        ));

    }

    // 상세 조회
    public TodoResult readTodo(long id) {
        return Optional.ofNullable(findById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "찾는 게시물이 없어요"));
    }

    public TodoResult findById(long id) {
        return todoRepository.findById(id);
    }

    public Map<Long, TodoResult> findAll() {
        return todoRepository.findAll();
    }
}
