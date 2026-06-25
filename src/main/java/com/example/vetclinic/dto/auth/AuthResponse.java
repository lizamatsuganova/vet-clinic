package com.example.vetclinic.dto.auth;

public record AuthResponse(
        String token,
        String username,
        String role
) {
}
