package com.khanhdx.finalproject.controller;

import com.khanhdx.finalproject.domain.model.Teacher;
import com.khanhdx.finalproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @version 1.0
 * @author KhanhDX
 * @since 9/28/2019
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/view-all-teacher")
    public List<Teacher> all(){
        return teacherService.viewAllTeacher();
    }

    @PostMapping("/create-teacher")
    public void add(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @PutMapping("/update-teacher/{teacherId}")
    public void update(@PathVariable(value = "teacherId") Long id, @RequestBody Teacher teacher){
        teacherService.updateTeacher(id,teacher);
    }

    @GetMapping("/search-teacher/{teacherId}")
    public Teacher searchTeacher(@PathVariable Long teacherId){
        return teacherService.getTeacherById(teacherId);
    }

    @DeleteMapping("/delete-teacher/{teacherId}")
    public void delete (@PathVariable(value = "teacherId") Long id){
        teacherService.delete(id);
    }
}
