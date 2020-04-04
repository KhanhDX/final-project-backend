package com.khanhdx.finalproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO implements Serializable {
    private Long studentId;
    private Long courseId;
    private Double amount;
    private Short status;
}
