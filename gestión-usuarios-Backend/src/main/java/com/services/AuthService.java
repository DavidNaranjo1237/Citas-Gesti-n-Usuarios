package com.services;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citas.gestion_usuarios.dtos.NewUserDto;
import com.citas.gestion_usuarios.entities.Role;
import com.citas.gestion_usuarios.entities.User;
import com.citas.gestion_usuarios.enums.RoleList;
import com.citas.gestion_usuarios.repositories.RoleRepository;

import jwt.JwtUtil;

@Service

public class AuthService {

    @SuppressWarnings("unused")
    private final RoleRepository roleRepository;
    @SuppressWarnings("unused")
    private final UserService userService;
    private final JwtUtil jwtUtil;
    @SuppressWarnings("unused")
    private final PasswordEncoder passwordEncoder;
    private Object authenticationManagerBuilder;

    public AuthService(RoleRepository roleRepository, UserService userService, JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder, Object authenticationManagerBuilder) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public AuthService(JwtUtil jwtUtil, PasswordEncoder passwordEncoder, RoleRepository roleRepository,
            UserService userService) {
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    public String authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);
        Authentication authResult = ((org.springframework.security.authentication.AuthenticationManager) authenticationManagerBuilder)
                .authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);

    }

    public void registerUser(NewUserDto newUserDto) {
        if (userService.existsByUsername(newUserDto.getUsername())) {
            throw new RuntimeException("el nombre del usuario ya existe");
        }

        final Role roleUser = roleRepository.findByName(RoleList.ROLE_USER)

                .orElseThrow(() -> new RuntimeException("Error: usuario no encontrado."));

        @SuppressWarnings("unused")
        User user = new User(newUserDto.getUsername(), passwordEncoder.encode(newUserDto.getPassword()), roleUser);
        userService.save(user);

    }

}
