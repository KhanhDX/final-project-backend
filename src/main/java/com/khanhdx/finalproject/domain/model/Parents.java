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
    private Long parentId;

    @Column(name = "parents_name")
    private String parentName;

    @Column(name = "parents_dob")
    private String parentDob;

    @Column(name = "parents_gender")
    private String parentGender;

    @Column(name = "parents_address")
    private String parentAddress;

    @Column(name = "parents_email")
    private String parentEmail;

    @Column(name = "parents_phone")
    private String parentPhone;

    @Column(name = "status")
    private String status;
}
