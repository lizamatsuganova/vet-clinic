package com.example.vetclinic.controller;

import com.example.vetclinic.entity.MedicalRecord;
import com.example.vetclinic.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public List<MedicalRecord> findAll() {
        return medicalRecordService.findAll();
    }

    @GetMapping("/{id}")
    public MedicalRecord findById(@PathVariable Long id) {
        return medicalRecordService.findById(id);
    }

    @GetMapping("/by-pet/{petId}")
    public List<MedicalRecord> findByPet(@PathVariable Long petId) {
        return medicalRecordService.findByPetId(petId);
    }
}
