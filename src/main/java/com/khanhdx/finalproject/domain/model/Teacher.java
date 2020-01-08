package com.khanhdx.finalproject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 9/28/2019
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_dob")
    private String teacherDob;

    @Column(name = "teacher_gender")
    private String teacherGender;

    @Column(name = "teacher_address")
    private String teacherAddress;

    @Column(name = "teacher_email")
    private String teacherEmail;

    @Column(name = "teacher_phone")
    private String teacherPhone;

    @Column(name = "status")
    private String status;
}
