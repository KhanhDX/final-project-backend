package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.domain.dto.ScheduleDTO;
import com.khanhdx.finalproject.domain.model.Schedule;
import com.khanhdx.finalproject.repository.ScheduleRepo;
import com.khanhdx.finalproject.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepo.findAll();
    }

    @Override
    public Schedule getScheduleById(Long scheduleId) {
        return scheduleRepo.findScheduleByScheduleId(scheduleId);
    }

    @Override
    public void addNewSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setCourseId(scheduleDTO.getCourseId());
        schedule.setStudentId(scheduleDTO.getStudentId());
        schedule.setTeacherId(scheduleDTO.getTeacherId());
        schedule.setStartDateTime(scheduleDTO.getStartDateTime());
        schedule.setEndDateTime(scheduleDTO.getEndDateTime());
        schedule.setStatus(scheduleDTO.getStatus());
        scheduleRepo.save(schedule);
    }

    @Override
    public void updateSchedule(Long scheduleId, ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepo.findScheduleByScheduleId(scheduleId);
        schedule.setStudentId(scheduleDTO.getStudentId());
        schedule.setTeacherId(scheduleDTO.getTeacherId());
        schedule.setStartDateTime(scheduleDTO.getStartDateTime());
        schedule.setEndDateTime(scheduleDTO.getEndDateTime());
        schedule.setStatus(scheduleDTO.getStatus());
        scheduleRepo.save(schedule);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        scheduleRepo.delete(scheduleRepo.findScheduleByScheduleId(scheduleId));
    }
}
