package com.khanhdx.finalproject.repository.implement;

import java.util.ArrayList;
import java.util.List;

import com.khanhdx.finalproject.domain.model.User;
import com.khanhdx.finalproject.repository.UserRepoCustom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 11/7/2019
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserRepoCustomImpl implements UserRepoCustom {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User loadUserByUsername(String username) {
        List<User> users = new ArrayList<>();
        Session session = this.sessionFactory.getCurrentSession();

        users = session.createQuery("from User where username=?", User.class)
                .setParameter(0, username).list();

         return (users.size() > 0) ? users.get(0) : null;
    }
}
