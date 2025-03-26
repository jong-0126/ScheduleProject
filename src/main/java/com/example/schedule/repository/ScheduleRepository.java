package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository {

    // 일정 생성
    ScheduleResponseDto saveSchedule(Schedule schedule);

    // 일정 전체 조회
    List<ScheduleResponseDto> findAllSchedule(LocalDate updated_at, String name);

    // 일정 단건 조회
    Schedule findScheduleByIdOrElseThrow(Long id);

    // 일정 선택 수정
    int updateSchedule(String todo, String name, Long id);

    // 일정 선택 삭제
    int deleteSchedule(Long id);
}
