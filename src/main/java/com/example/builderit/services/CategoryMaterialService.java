package com.example.builderit.services;

import com.example.builderit.dto.CategoryMaterialDto;
import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.models.WorkGroup;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CategoryMaterialService {
    CategoryMaterialDto addCategoryMaterial (CategoryMaterialDto categoryMaterialDto);

    List<CategoryMaterialDto> getAllCategoryMaterials();
}
