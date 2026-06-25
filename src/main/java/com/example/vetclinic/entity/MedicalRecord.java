package com.example.vetclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String diagnosis;

    @Column(nullable = false, length = 255)
    private String treatment;

    @Column(nullable = false)
    private LocalDateTime recordDate;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @PrePersist
    void onCreate() {
        if (recordDate == null) {
            recordDate = LocalDateTime.now();
        }
    }
}
