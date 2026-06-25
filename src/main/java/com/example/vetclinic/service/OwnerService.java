package com.example.vetclinic.service;

import com.example.vetclinic.entity.Owner;
import com.example.vetclinic.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found: " + id));
    }

    public Owner findByPhone(String phone) {
        return ownerRepository.findByPhone(phone)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found by phone: " + phone));
    }

    public List<Owner> searchByName(String name) {
        return ownerRepository.findByFullNameContainingIgnoreCase(name);
    }
}
