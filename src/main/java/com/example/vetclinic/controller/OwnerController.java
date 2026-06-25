package com.example.vetclinic.controller;

import com.example.vetclinic.entity.Owner;
import com.example.vetclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping
    public List<Owner> findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public Owner findById(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @GetMapping("/by-phone/{phone}")
    public Owner findByPhone(@PathVariable String phone) {
        return ownerService.findByPhone(phone);
    }

    @GetMapping("/search")
    public List<Owner> search(@RequestParam String name) {
        return ownerService.searchByName(name);
    }
}
