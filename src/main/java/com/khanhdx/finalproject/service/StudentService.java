package com.khanhdx.finalproject.service;

import com.khanhdx.finalproject.domain.dto.StudentDTO;
import com.khanhdx.finalproject.domain.model.Course;
import com.khanhdx.finalproject.domain.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent ();

    Student getStudentById (Long studentId);

    void addNewStudent(StudentDTO studentDTO);

    void updateStudent(Long studentId, StudentDTO studentDTO);

    void deleteStudent(Long studentId);
}
