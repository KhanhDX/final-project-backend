package com.khanhdx.finalproject.service;

import com.khanhdx.finalproject.domain.dto.ScheduleDTO;
import com.khanhdx.finalproject.domain.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getAllSchedule ();

    Schedule getScheduleById (Long scheduleId);

    void addNewSchedule(ScheduleDTO scheduleDTO);

    void updateSchedule(Long scheduleId, ScheduleDTO scheduleDTO);

    void deleteSchedule(Long scheduleId);
}
