package com.khanhdx.finalproject.controller;

import com.khanhdx.finalproject.domain.model.Course;
import com.khanhdx.finalproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseaService;

    @GetMapping("view-all-courses")
    public ResponseEntity<List<Course>> getAllCourse (){
        return new ResponseEntity<>(courseaService.getAllCourse(), HttpStatus.OK);
    }
}
