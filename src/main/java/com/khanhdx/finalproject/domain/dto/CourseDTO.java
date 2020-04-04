package com.khanhdx.finalproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO implements Serializable {
    private String courseName;
    private Long teacherId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Double price;
    private Short status;
}
