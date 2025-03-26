package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.mysql.cj.result.Row;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 생성
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todo", schedule.getTodo());
        parameters.put("name", schedule.getName());
        parameters.put("password", schedule.getPassword());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ScheduleResponseDto(key.longValue(), schedule.getTodo(), schedule.getName());
    }

    // 전체 일정 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return jdbcTemplate.query("select * from schedule order by 2 desc", scheduleRowMapper());
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper(){
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        };
    }

    // 일정 단건 조회
    @Override
    public Schedule findScheduleByIdOrElseThrow(Long id) {

        List<Schedule> result = jdbcTemplate.query("select * from schedule where id = ?", scheduleRowMapperV2(), id) ;
        return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exists id = " + id));
    }

    private RowMapper<Schedule> scheduleRowMapperV2(){
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        };
    }

    // 일정 선택 수정
    @Override
    public int updateSchedule(String todo, String name, Long id) {

        return jdbcTemplate.update("update schedule set todo = if(? is null , todo, ?), name = if(? is null, name, ?) where id = ?",todo, todo, name, name, id);
    }


    // 선택 삭제
    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("delete from schedule where id = ? ", id);
    }

}
