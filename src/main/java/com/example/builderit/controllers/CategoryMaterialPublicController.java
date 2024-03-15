package com.example.builderit.controllers;

import com.example.builderit.dto.CategoryMaterialDto;
import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.services.impl.CategoryMaterialServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public/categoryMaterial")
@CrossOrigin("http://localhost:3000/")
public class CategoryMaterialPublicController {
    private final CategoryMaterialServiceImpl categoryMaterialService;

    @GetMapping
    public ResponseEntity<List<CategoryMaterialDto>> categoryMaterialDto() {
        return ResponseEntity.ok(categoryMaterialService.getAllCategoryMaterials());
    }

}
