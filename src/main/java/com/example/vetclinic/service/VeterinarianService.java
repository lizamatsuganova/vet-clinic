package com.example.vetclinic.service;

import com.example.vetclinic.entity.Veterinarian;
import com.example.vetclinic.repository.VeterinarianRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarianService {
    private final VeterinarianRepository veterinarianRepository;

    public List<Veterinarian> findAll() {
        return veterinarianRepository.findAll();
    }

    public Veterinarian findById(Long id) {
        return veterinarianRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veterinarian not found: " + id));
    }
}
