package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByUsername (String username);

    List<User> findByUsernameOrEmail(String username, String email);
}
