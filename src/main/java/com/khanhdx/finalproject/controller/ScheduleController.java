package com.khanhdx.finalproject.controller;

import com.khanhdx.finalproject.domain.dto.ScheduleDTO;
import com.khanhdx.finalproject.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/schedule")
@CrossOrigin("*")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("view-all-schedules")
    public ResponseEntity viewAllSchedules(@RequestParam Long scheduleId) {
        return Objects.isNull(scheduleId) ?
                new ResponseEntity(scheduleService.getAllSchedule(), HttpStatus.OK) :
                new ResponseEntity(scheduleService.getScheduleById(scheduleId), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity addNewSchedule(@RequestBody ScheduleDTO scheduleDTO){
        scheduleService.addNewSchedule(scheduleDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateStudent(@RequestParam Long scheduleId, @RequestBody ScheduleDTO scheduleDTO){
        scheduleService.updateSchedule(scheduleId, scheduleDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity deleteStudent (Long scheduleId){
        scheduleService.deleteSchedule(scheduleId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
