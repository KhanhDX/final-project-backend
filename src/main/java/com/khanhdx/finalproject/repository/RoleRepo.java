package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.enums.RoleName;
import com.khanhdx.finalproject.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
