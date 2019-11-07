package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>, UserRepoCustom {
    User findUserByUsername (String username);
}
