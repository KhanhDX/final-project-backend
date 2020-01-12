package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.domain.model.Teacher;
import com.khanhdx.finalproject.repository.TeacherRepo;
import com.khanhdx.finalproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 9/28/2019
 */

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public List<Teacher> viewAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    @Override
    public void updateTeacher(Long teacherId, Teacher teacher) {
        Teacher teacher1 = teacherRepo.findTeacherByTeacherId(teacherId);
        teacher1.setTeacherName(teacher.getTeacherName());
        teacher1.setTeacherDob(teacher.getTeacherDob());
        teacher1.setTeacherGender(teacher.getTeacherGender());
        teacher1.setTeacherAddress(teacher.getTeacherAddress());
        teacher1.setTeacherEmail(teacher.getTeacherEmail());
        teacher1.setTeacherPhone(teacher.getTeacherPhone());
        teacher1.setStatus(teacher.getStatus());
        teacherRepo.save(teacher1);
    }

    @Override
    public void delete(Long teacherId) {
        Teacher teacher = teacherRepo.findTeacherByTeacherId(teacherId);
        teacherRepo.delete(teacher);
    }
}
