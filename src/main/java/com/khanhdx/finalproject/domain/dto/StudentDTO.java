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
public class StudentDTO implements Serializable {
    private String studentName;
    private String studentDob;
    private String studentGender;
    private String studentAddress;
    private String studentEmail;
    private String studentPhone;
    private Short status;
}
