package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.Entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 9/28/2019
 */

@Repository
public interface Repositories extends JpaRepository<Entities, Long> {
    Entities findEntitiesById (Long id);
}
