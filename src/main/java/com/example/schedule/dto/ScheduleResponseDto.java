package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String todo;
    private String name;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    // entity Dto로 변환
    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.todo = schedule.getTodo();
        this.name = schedule.getName();
        this.createAt = schedule.getCreatedAt();
        this.updateAt = schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(long id, String todo, String name) {
        this.id = id;
        this.todo = todo;
        this.name = name;
    }
}
