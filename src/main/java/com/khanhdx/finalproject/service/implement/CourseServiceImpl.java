package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.domain.dto.CourseDTO;
import com.khanhdx.finalproject.domain.model.Course;
import com.khanhdx.finalproject.repository.CourseRepo;
import com.khanhdx.finalproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepo.findCourseByCourseId(courseId);
    }

    @Override
    public void addNewCourse(CourseDTO courseDTO) throws Exception {
        checkInputValidate(courseDTO);

        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setTeacherId(courseDTO.getTeacherId());
        course.setStartDateTime(courseDTO.getStartDateTime());
        course.setEndDateTime(courseDTO.getEndDateTime());
        course.setPrice(courseDTO.getPrice());
        course.setStatus(courseDTO.getStatus());
        courseRepo.save(course);
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) throws Exception {
        checkInputValidate(courseDTO);

        Course course = courseRepo.findCourseByCourseId(courseId);
        if (Objects.isNull(course)) throw new Exception("Khong ton tai mon hoc trong he thong !");

        course.setCourseName(courseDTO.getCourseName());
        course.setTeacherId(courseDTO.getTeacherId());
        course.setStartDateTime(courseDTO.getStartDateTime());
        course.setEndDateTime(courseDTO.getEndDateTime());
        course.setPrice(courseDTO.getPrice());
        course.setStatus(courseDTO.getStatus());
        courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.delete(courseRepo.findCourseByCourseId(id));
    }

    private void checkInputValidate(CourseDTO courseDTO) throws Exception {
        if (Objects.isNull(courseDTO.getCourseName())) throw new Exception("Ten mon hoc khong duoc de trong");
        if (Objects.isNull(courseDTO.getTeacherId())) throw new Exception("Ten giao vien khong duoc de trong");
        if (Objects.isNull(courseDTO.getEndDateTime())) throw new Exception("Ngay ket thuc khong duoc de trong");
        if (Objects.isNull(courseDTO.getStartDateTime())) throw new Exception("Ngay bat dau khong duoc de trong");
        if (Objects.isNull(courseDTO.getPrice())) throw new Exception("Gia tien khong duoc de trong");
        if (Objects.isNull(courseDTO.getStatus())) throw new Exception("Trang thai khong duoc de trong");
    }
}
