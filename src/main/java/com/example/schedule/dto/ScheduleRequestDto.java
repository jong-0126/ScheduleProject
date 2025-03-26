package com.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequestDto {

    private String todo;
    private String name;
    private String password;
    private LocalDate updated_at;

}
