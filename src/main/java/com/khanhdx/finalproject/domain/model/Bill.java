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
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private Long courseId;

    @Column(name = "student_id")
    private Long courseName;

    @Column(name = "course_id")
    private Long teacherId;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private Long status;
}
