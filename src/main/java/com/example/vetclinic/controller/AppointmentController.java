package com.example.vetclinic.controller;

import com.example.vetclinic.entity.Appointment;
import com.example.vetclinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment findById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @GetMapping("/by-pet/{petId}")
    public List<Appointment> findByPet(@PathVariable Long petId) {
        return appointmentService.findByPetId(petId);
    }

    @GetMapping("/by-vet/{vetId}")
    public List<Appointment> findByVet(@PathVariable Long vetId) {
        return appointmentService.findByVeterinarianId(vetId);
    }
}
