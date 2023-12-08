package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.exception.ElibAPIException;
import com.dtu.elibrary.model.Role;
import com.dtu.elibrary.model.User;
import com.dtu.elibrary.payload.LoginDto;
import com.dtu.elibrary.payload.RegisterDto;
import com.dtu.elibrary.repository.RoleRepository;
import com.dtu.elibrary.repository.UserRepository;
import com.dtu.elibrary.security.JwtTokenProvider;
import com.dtu.elibrary.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {
    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getUsernameOrEmail(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        // Check if database exist username or not
        if (userRepository.existsByUsername(registerDto.getUsername()))
            throw new ElibAPIException(HttpStatus.BAD_REQUEST, "This username is already used");
        if (userRepository.existsByEmail(registerDto.getEmail()))
            throw new ElibAPIException(HttpStatus.BAD_REQUEST, "This email is already used");

        User newUser = new User();
        newUser.setName(registerDto.getName());
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        newUser.setPhone(registerDto.getPhone());
        newUser.setAge(LocalDate.now().getYear() - registerDto.getBirthday().getYear());
        newUser.setDate(LocalDate.now());
        newUser.setGender(registerDto.isGender());

        Role role = roleRepository.findByRoleName("ROLE_USER");
        newUser.setRole(role);

        userRepository.save(newUser);

        return "User register successfully";
    }
}
