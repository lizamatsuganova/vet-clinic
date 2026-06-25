package com.example.vetclinic.service;

import com.example.vetclinic.entity.Appointment;
import com.example.vetclinic.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found: " + id));
    }

    public List<Appointment> findByPetId(Long petId) {
        return appointmentRepository.findByPetId(petId);
    }

    public List<Appointment> findByVeterinarianId(Long veterinarianId) {
        return appointmentRepository.findByVeterinarianId(veterinarianId);
    }
}
