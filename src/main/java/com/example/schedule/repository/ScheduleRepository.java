package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    // 일정 생성
    ScheduleResponseDto saveSchedule(Schedule schedule);

    // 일정 전체 조회
    List<ScheduleResponseDto> findAllSchedule();

    // 일정 단건 조회
    Schedule findScheduleByIdOrElseThrow(Long id);

    // 일정 선택 조회
    int deleteSchedule(Long id);
}
