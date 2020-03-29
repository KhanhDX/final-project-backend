package com.khanhdx.finalproject.service.implement;

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
}
