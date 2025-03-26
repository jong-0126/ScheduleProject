package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto){

        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

    //전체 일정 조회
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedule(){
        return scheduleService.findAllSchedule();
    }

    //선택 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    //선택 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable("id") Long id,
            @RequestBody ScheduleRequestDto dto
    ){
        return new ResponseEntity<>(scheduleService.updateSchedule(id, dto.getTodo(), dto.getName(), dto.getPassword()), HttpStatus.OK);
    }

    //선택 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Long id){
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
