package com.khanhdx.finalproject.repository;

import com.khanhdx.finalproject.domain.model.Teacher;
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
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Teacher findTeacherByTeacherId(Long id);
}
