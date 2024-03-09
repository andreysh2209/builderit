package com.example.builderit.controllers;

import com.example.builderit.enums.MeasurementType;
import com.example.builderit.services.impl.MaterialServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materials")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class MaterialController {
    private final MaterialServiceImpl materialService;

    @GetMapping("/measurementTypes")
    public ResponseEntity<List<String>> getMeasurementTypes(){
        return ResponseEntity.ok(materialService.getMeasurementTypes());

    }
}
