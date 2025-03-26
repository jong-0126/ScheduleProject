package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String todo;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Schedule(String todo, String name, String password) {
        this.todo = todo;
        this.name = name;
        this.password = password;
    }
}