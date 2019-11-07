package com.khanhdx.finalproject.domain.model;

import javax.persistence.*;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 11/7/2019
 */
@Entity
@Table(name = "users_roles", catalog = "spring_security")
public class UsersRoles implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Role role;
    private User users;
    public UsersRoles() {
    }
    public UsersRoles(Role role, User users) {
        this.role = role;
        this.users = users;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    public User getUsers() {
        return this.users;
    }
    public void setUsers(User users) {
        this.users = users;
    }
}
