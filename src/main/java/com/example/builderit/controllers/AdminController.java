package com.example.builderit.controllers;

import com.example.builderit.dto.*;
import com.example.builderit.models.WorkGroup;
import com.example.builderit.services.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin("http://localhost:3000/")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private  final WorkGroupServiceImpl workGroupService;
    private final SubWorkGroupServiceImpl subWorkGroupService;
    private final MaterialServiceImpl materialService;
    private final WorkTypeServiceImpl workTypeService;
    private final CategoryMaterialServiceImpl categoryMaterialService;
    @PostMapping ("/addGroupWork")
    public ResponseEntity<List<WorkGroupDto>> addWorkGroup (WorkGroup workGroup, MultipartFile file) throws IOException {
        return ResponseEntity.ok( workGroupService.addWorkGroup(workGroup, file))  ;

    }
    @PostMapping ("/addSubGroupWork")
    public SubWorkGroupDto addSubWorkGroup (@RequestBody SubWorkGroupDto subWorkGroupDto) {
        return subWorkGroupService.addSubWorkGroup(subWorkGroupDto);
    }
    @PostMapping ("/addMaterial")
    public MaterialDto addMaterial (@RequestBody MaterialDto materialDto) {
        return materialService.addMaterial(materialDto);
    }
    @PostMapping ("/addWorkType")
    public WorkTypeDto addWorkType (@RequestBody WorkTypeDto workTypeDto) {
        return workTypeService.addWorkType(workTypeDto);
    }
    @PostMapping ("/addCategoryMaterial")
    public CategoryMaterialDto addCategoryMaterial (@RequestBody CategoryMaterialDto categoryMaterialDto) {
        return categoryMaterialService.addCategoryMaterial(categoryMaterialDto);
    }
}
