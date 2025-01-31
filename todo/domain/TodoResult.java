package com.example.springdemo.todo.domain;

import java.time.LocalDateTime;

public record TodoResult (
        long id,
        String title,
        String content,
        LocalDateTime date
) {

}
