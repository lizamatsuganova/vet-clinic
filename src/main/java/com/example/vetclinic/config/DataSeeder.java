package com.example.vetclinic.config;

import com.example.vetclinic.entity.*;
import com.example.vetclinic.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VeterinarianRepository veterinarianRepository;
    private final AppointmentRepository appointmentRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (appUserRepository.count() == 0) {
            appUserRepository.save(AppUser.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("Admin123!"))
                    .role(UserRole.ROLE_ADMIN)
                    .build());

            appUserRepository.save(AppUser.builder()
                    .username("doctor")
                    .password(passwordEncoder.encode("Doctor123!"))
                    .role(UserRole.ROLE_DOCTOR)
                    .build());
        }

        if (ownerRepository.count() == 0) {
            Owner owner1 = ownerRepository.save(Owner.builder()
                    .fullName("Ivan Petrov")
                    .phone("+1-202-555-0111")
                    .email("ivan.petrov@example.com")
                    .address("12 Maple Street, Centreville")
                    .build());

            Owner owner2 = ownerRepository.save(Owner.builder()
                    .fullName("Anna Smirnova")
                    .phone("+1-202-555-0222")
                    .email("anna.smirnova@example.com")
                    .address("44 Oak Avenue, Fairfax")
                    .build());

            Veterinarian vet1 = veterinarianRepository.save(Veterinarian.builder()
                    .fullName("Dr. Elena Morris")
                    .licenseNumber("VET-10001")
                    .specialization("Therapy")
                    .active(true)
                    .build());

            Veterinarian vet2 = veterinarianRepository.save(Veterinarian.builder()
                    .fullName("Dr. Robert Lane")
                    .licenseNumber("VET-10002")
                    .specialization("Surgery")
                    .active(true)
                    .build());

            Pet pet1 = petRepository.save(Pet.builder()
                    .name("Bim")
                    .species("Dog")
                    .breed("Labrador")
                    .birthDate(LocalDate.of(2020, 3, 12))
                    .sex("M")
                    .chipNumber("CHIP-0001")
                    .owner(owner1)
                    .build());

            Pet pet2 = petRepository.save(Pet.builder()
                    .name("Murka")
                    .species("Cat")
                    .breed("British Shorthair")
                    .birthDate(LocalDate.of(2021, 7, 8))
                    .sex("F")
                    .chipNumber("CHIP-0002")
                    .owner(owner2)
                    .build());

            appointmentRepository.save(Appointment.builder()
                    .appointmentTime(LocalDateTime.now().plusDays(1))
                    .reason("Vaccination")
                    .status(AppointmentStatus.SCHEDULED)
                    .pet(pet1)
                    .veterinarian(vet1)
                    .build());

            appointmentRepository.save(Appointment.builder()
                    .appointmentTime(LocalDateTime.now().plusDays(2))
                    .reason("Annual check-up")
                    .status(AppointmentStatus.SCHEDULED)
                    .pet(pet2)
                    .veterinarian(vet2)
                    .build());

            medicalRecordRepository.save(MedicalRecord.builder()
                    .diagnosis("Healthy")
                    .treatment("No treatment required")
                    .pet(pet1)
                    .build());

            medicalRecordRepository.save(MedicalRecord.builder()
                    .diagnosis("Mild allergy")
                    .treatment("Antihistamine for 5 days")
                    .pet(pet2)
                    .build());
        }
    }
}
