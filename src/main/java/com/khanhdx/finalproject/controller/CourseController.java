package com.khanhdx.finalproject.controller;

import com.khanhdx.finalproject.domain.dto.CourseDTO;
import com.khanhdx.finalproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("view-all-courses")
    public ResponseEntity<?> getAllCourse(@RequestParam Long courseId) {
        return Objects.isNull(courseId) ?
                new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK) :
                new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);

    }

    @PostMapping("create")
    public ResponseEntity createNewCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addNewCourse(courseDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateCourse(@RequestParam Long courseId, @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(courseId, courseDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("delete/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
