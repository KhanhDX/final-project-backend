package com.khanhdx.finalproject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private Long courseName;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_name")
    private Long teacherName;

    @Column(name = "start_datetime")
    private Long startDateTime;

    @Column(name = "endDateTime")
    private Long endDateTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private Short status;
}
