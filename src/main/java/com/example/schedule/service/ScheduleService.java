package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {

    // 일정 생성
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    // 일정 전체 조회
    List<ScheduleResponseDto> findAllSchedule();

    // 일정 선택 조회
    ScheduleResponseDto findScheduleById(Long id);

    // 일정 선택 수정
    ScheduleResponseDto updateSchedule(Long id, String todo, String name, String password);

    // 일정 선택 삭제
    void deleteSchedule(Long id);
}
