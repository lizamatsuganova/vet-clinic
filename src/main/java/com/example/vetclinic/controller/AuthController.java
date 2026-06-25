package com.example.vetclinic.controller;

import com.example.vetclinic.dto.auth.AuthResponse;
import com.example.vetclinic.dto.auth.LoginRequest;
import com.example.vetclinic.dto.auth.RegisterRequest;
import com.example.vetclinic.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
