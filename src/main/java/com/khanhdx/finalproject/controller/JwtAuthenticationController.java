package com.khanhdx.finalproject.controller;


import com.khanhdx.finalproject.config.security.JwtTokenProvider;
import com.khanhdx.finalproject.config.util.JwtTokenUtil;
import com.khanhdx.finalproject.domain.dto.request.LoginRequest;
import com.khanhdx.finalproject.domain.dto.request.SignUpRequest;
import com.khanhdx.finalproject.domain.dto.response.ApiResponse;
import com.khanhdx.finalproject.domain.dto.response.JwtAuthenticationResponse;
import com.khanhdx.finalproject.domain.enums.RoleName;
import com.khanhdx.finalproject.domain.model.Role;
import com.khanhdx.finalproject.domain.model.User;
import com.khanhdx.finalproject.exception.AppException;
import com.khanhdx.finalproject.repository.RoleRepo;
import com.khanhdx.finalproject.repository.UserRepo;
import com.khanhdx.finalproject.service.implement.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepo roleRepo;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(SecurityContextHolder.getContext());
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepo.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully"));
    }
}
