package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Course findCourseByCourseId(Long courseId);
}
