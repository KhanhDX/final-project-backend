package com.khanhdx.finalproject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private String courseName;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "start_datetime")
    private LocalDateTime startDateTime;

    @Column(name = "end_dateTime")
    private LocalDateTime endDateTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private Short status;
}
