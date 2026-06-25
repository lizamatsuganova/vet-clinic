package com.example.vetclinic.service;

import com.example.vetclinic.entity.MedicalRecord;
import com.example.vetclinic.repository.MedicalRecordRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord findById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medical record not found: " + id));
    }

    public List<MedicalRecord> findByPetId(Long petId) {
        return medicalRecordRepository.findByPetId(petId);
    }
}
