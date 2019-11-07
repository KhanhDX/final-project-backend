package com.khanhdx.finalproject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 36, nullable = false)
    private String userName;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "enabled", length = 128, nullable = false)
    private Integer enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    public Set<UsersRoles> getUsersRoleses() {
        return this.getUsersRoleses();
    }

    @Transient
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UsersRoles usersRoles: this.getUsersRoleses()) {
            authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getName()));
        }
        return authorities;
    }


}
