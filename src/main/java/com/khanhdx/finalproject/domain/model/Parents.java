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
@Table(name = "parents")
public class Parents implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parents_id")
    private Long teacherId;

    @Column(name = "parents_name")
    private String teacherName;

    @Column(name = "parents_age")
    private String teacherAge;

    @Column(name = "parents_gender")
    private String teacherGender;

    @Column(name = "parents_address")
    private String teacherAddress;

    @Column(name = "parents_email")
    private String teacherEmail;

    @Column(name = "parents_phone")
    private String teacherPhone;

    @Column(name = "status")
    private String status;
}
