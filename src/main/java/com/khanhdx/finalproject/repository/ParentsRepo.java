package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsRepo extends JpaRepository<Parents, Long> {
}
