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

    public Schedule(Long id, String todo, String name, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.todo = todo;
        this.name = name;
        this.createdAt = createAt;
        this.updatedAt = updateAt;
    }
}