package com.khanhdx.finalproject;

import com.khanhdx.finalproject.domain.model.Entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositories extends JpaRepository<Entities, Long> {
    Entities findEntitiesById (Long id);
}
