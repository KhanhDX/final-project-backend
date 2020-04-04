package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.domain.dto.CourseDTO;
import com.khanhdx.finalproject.domain.model.Course;
import com.khanhdx.finalproject.repository.CourseRepo;
import com.khanhdx.finalproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepo.findCourseByCourseId(courseId);
    }

    @Override
    public void addNewCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setTeacherId(courseDTO.getTeacherId());
        course.setStartDateTime(courseDTO.getStartDateTime());
        course.setEndDateTime(courseDTO.getEndDateTime());
        course.setPrice(courseDTO.getPrice());
        course.setStatus(courseDTO.getStatus());
        courseRepo.save(course);
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {


        Course course = courseRepo.findCourseByCourseId(courseId);
        course.setCourseName(courseDTO.getCourseName());
        course.setTeacherId(courseDTO.getTeacherId());
        course.setStartDateTime(courseDTO.getStartDateTime());
        course.setEndDateTime(courseDTO.getEndDateTime());
        course.setPrice(courseDTO.getPrice());
        course.setStatus(courseDTO.getStatus());
        courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.delete(courseRepo.findCourseByCourseId(id));
    }
}
