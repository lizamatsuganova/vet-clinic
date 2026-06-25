package com.example.vetclinic.repository;

import com.example.vetclinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByPhone(String phone);
    List<Owner> findByFullNameContainingIgnoreCase(String fullName);
}
