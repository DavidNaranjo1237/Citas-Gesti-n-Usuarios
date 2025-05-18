package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citas.gestion_usuarios.dtos.LoginUserDto;
import com.citas.gestion_usuarios.dtos.NewUserDto;
import com.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("revise sus credenciales");
        }

        try {
            String jwt = authService.authenticate(loginUserDto.username, loginUserDto.getPassword());
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("revise sus credenciales");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody NewUserDto newUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("revise sus credenciales");
        }

        try {
            authService.registerUser(newUserDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("el nombre del usuario ya existe");
        }
    }

    @PostMapping("/check-auth")
    public ResponseEntity<String> checkAuth() {
        return ResponseEntity.ok("Usuario autenticado");

    }

}
