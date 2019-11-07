package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Class name.
 *
 * @version 1.0
 * @author KhanhDX
 * @since 11/7/2019
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.khanhdx.finalproject.domain.model.User user = userDAO.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username Not Found");
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(username, user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, user.getAuthorities());
    }
}
