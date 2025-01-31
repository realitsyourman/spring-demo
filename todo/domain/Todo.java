package com.example.springdemo.todo.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter @Setter
public class Todo {
    private long id;
    private String title;
    private String content;
    private LocalDateTime date;

    public Todo(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
    }
}
