package com.example.vetclinic.controller;

import com.example.vetclinic.entity.Pet;
import com.example.vetclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public Pet findById(@PathVariable Long id) {
        return petService.findById(id);
    }

    @GetMapping("/by-owner/{ownerId}")
    public List<Pet> findByOwner(@PathVariable Long ownerId) {
        return petService.findByOwnerId(ownerId);
    }

    @GetMapping("/search")
    public List<Pet> searchBySpecies(@RequestParam String species) {
        return petService.searchBySpecies(species);
    }
}
