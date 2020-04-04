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
public class ScheduleDTO implements Serializable {
    private Long studentId;

    private Long teacherId;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private Long courseId;

    private Short status;
}
