package com.example.vetclinic.controller;

import com.example.vetclinic.entity.Veterinarian;
import com.example.vetclinic.service.VeterinarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
@RequiredArgsConstructor
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    @GetMapping
    public List<Veterinarian> findAll() {
        return veterinarianService.findAll();
    }

    @GetMapping("/{id}")
    public Veterinarian findById(@PathVariable Long id) {
        return veterinarianService.findById(id);
    }
}
