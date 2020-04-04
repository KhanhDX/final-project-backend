package com.khanhdx.finalproject.controller;

import com.khanhdx.finalproject.domain.dto.StudentDTO;
import com.khanhdx.finalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("view-all-students")
    public ResponseEntity viewAllStudent(@RequestParam Long studentId) {
        return Objects.isNull(studentId) ?
                new ResponseEntity(studentService.getAllStudent(), HttpStatus.OK) :
                new ResponseEntity(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity addNewStudent(@RequestBody StudentDTO studentDTO){
        studentService.addNewStudent(studentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateStudent(@RequestParam Long studentId, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(studentId, studentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity deleteStudent (Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
