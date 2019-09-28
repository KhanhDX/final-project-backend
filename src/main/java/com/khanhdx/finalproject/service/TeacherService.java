package com.khanhdx.finalproject.service;

import com.khanhdx.finalproject.domain.model.Teacher;

import java.util.List;

/**
 * @version 1.0
 * @author KhanhDX
 * @since 9/28/2019
 */
public interface TeacherService {
    List<Teacher> viewAllTeacher();

    void addTeacher(Teacher teacher);

    void updateTeacher(Long teacherId, Teacher teacher);

    void delete (Long teacherId);
}
