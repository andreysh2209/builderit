package com.example.builderit.services.impl;

import com.example.builderit.converter.CategoryMaterialToCategoryMaterialDtoConvertor;
import com.example.builderit.dto.CategoryMaterialDto;
import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.repositories.CategoryMaterialRepository;
import com.example.builderit.services.CategoryMaterialService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryMaterialServiceImpl implements CategoryMaterialService {
    private final CategoryMaterialRepository categoryMaterialRepository;
    private final CategoryMaterialToCategoryMaterialDtoConvertor categoryMaterialToCategoryMaterialDtoConvertor;

    public CategoryMaterialServiceImpl(CategoryMaterialRepository categoryMaterialRepository, CategoryMaterialToCategoryMaterialDtoConvertor categoryMaterialToCategoryMaterialDtoConvertor) {
        this.categoryMaterialRepository = categoryMaterialRepository;
        this.categoryMaterialToCategoryMaterialDtoConvertor = categoryMaterialToCategoryMaterialDtoConvertor;
    }

    @Override
    public List<CategoryMaterialDto> addCategoryMaterial(CategoryMaterial categoryMaterial) {
        return null;
    }

    @Override
    public List<CategoryMaterialDto> getAllCategoryMaterials() {

        return categoryMaterialRepository.findAll()
                .stream()
                .map(categoryMaterialToCategoryMaterialDtoConvertor::convert)
                .toList();

    }


}
