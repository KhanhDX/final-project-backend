package com.khanhdx.finalproject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
@Table(name = "app_user", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "password", length = 128, nullable = false)
    private String password;
}
