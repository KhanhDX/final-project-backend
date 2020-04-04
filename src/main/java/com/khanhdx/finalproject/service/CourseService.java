package com.khanhdx.finalproject.service;


import com.khanhdx.finalproject.domain.dto.CourseDTO;
import com.khanhdx.finalproject.domain.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse ();

    Course getCourseById (Long courseId);

    void addNewCourse(CourseDTO courseDTO);

    void updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);
}
