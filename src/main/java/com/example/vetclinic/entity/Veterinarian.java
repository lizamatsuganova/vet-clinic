package com.example.vetclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinarians")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String fullName;

    @Column(nullable = false, unique = true, length = 120)
    private String licenseNumber;

    @Column(nullable = false, length = 120)
    private String specialization;

    @Column(nullable = false)
    private boolean active;

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "veterinarian")
    private List<Appointment> appointments = new ArrayList<>();
}
