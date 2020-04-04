package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByStudentId (Long studentId);
}
