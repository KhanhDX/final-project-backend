package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.domain.dto.StudentDTO;
import com.khanhdx.finalproject.domain.model.Course;
import com.khanhdx.finalproject.domain.model.Student;
import com.khanhdx.finalproject.repository.StudentRepo;
import com.khanhdx.finalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepo.findStudentByStudentId(studentId);
    }

    @Override
    public void addNewStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentName(student.getStudentName());
        student.setStudentDob(student.getStudentDob());
        student.setStudentGender(student.getStudentGender());
        student.setStudentAddress(student.getStudentAddress());
        student.setStudentEmail(student.getStudentEmail());
        student.setStudentPhone(student.getStudentPhone());
        student.setStatus(student.getStatus());

        studentRepo.save(student);
    }

    @Override
    public void updateCourse(Long studentId, StudentDTO studentDTO) {

    }

    @Override
    public void deleteCourse(Long studentId) {

    }
}
