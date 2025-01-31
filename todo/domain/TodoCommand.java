package com.example.springdemo.todo.domain;

public record TodoCommand(
        String title,
        String content
) {
}
