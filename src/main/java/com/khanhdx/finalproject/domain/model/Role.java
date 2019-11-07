package com.khanhdx.finalproject.domain.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 11/7/2019
 */
@Entity
@Table(name = "role", catalog = "spring_security")
public class Role implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
    public Role() {
    }
    public Role(String name, Set<UsersRoles> usersRoleses) {
        this.name = name;
        this.usersRoleses = usersRoleses;
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
    @Column(name = "name", length = 45)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<UsersRoles> getUsersRoleses() {
        return this.usersRoleses;
    }
    public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
        this.usersRoleses = usersRoleses;
    }

}
