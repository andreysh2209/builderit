package com.example.builderit.controllers;

import com.example.builderit.dto.ApartmentDto;
import com.example.builderit.services.impl.ApartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apartments")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ApartmentController {
    private final ApartmentServiceImpl apartmentService;

    @GetMapping("/getRoomTypes")
    public ResponseEntity<List<String>> getRoomTypes() {
        return ResponseEntity.ok(apartmentService.getRoomTypes());
    }

    @PostMapping("/addAppartment")
    public ResponseEntity<List<ApartmentDto>> addApartment(@RequestBody ApartmentDto apartmentDto) {
        return null;
    }
}
