package com.example.springdemo.todo.adapter.web;

import com.example.springdemo.todo.domain.TodoCommand;
import com.example.springdemo.todo.domain.TodoResult;
import com.example.springdemo.todo.usecase.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public TodoResult todoWrite(@RequestBody TodoCommand todo) {

        return todoService.write(todo);
    }

    @GetMapping("/list")
    public Map<Long, String> getList() {
        return todoService.getTitleList();
    }

    @GetMapping("/{id}")
    public TodoResult getTodoContent(@PathVariable("id") long id) {
        return todoService.readTodo(id);
    }
}
