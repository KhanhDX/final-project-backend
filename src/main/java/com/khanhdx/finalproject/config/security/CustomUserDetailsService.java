package com.khanhdx.finalproject.config.security;

import com.khanhdx.finalproject.domain.model.User;
import com.khanhdx.finalproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepo userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
    // Let people login with either username or email
    List<User> user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

    return UserPrincipal.create(user.get(0));
  }

  @Transactional
  public UserDetails loadUserById(Integer id) {
    Optional<User> user = userRepository.findById(id);

    return UserPrincipal.create(user.get());
  }
}
