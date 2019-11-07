package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.User;

public interface UserRepoCustom {
    User loadUserByUsername(String username);
}
