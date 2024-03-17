package com.example.builderit.services.impl;

import com.example.builderit.converter.CategoryMaterialDtoToCategoryMaterialConvertor;
import com.example.builderit.converter.CategoryMaterialToCategoryMaterialDtoConvertor;
import com.example.builderit.dto.CategoryMaterialDto;
import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.repositories.CategoryMaterialRepository;
import com.example.builderit.services.CategoryMaterialService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryMaterialServiceImpl implements CategoryMaterialService {
    private final CategoryMaterialRepository categoryMaterialRepository;
    private final CategoryMaterialToCategoryMaterialDtoConvertor categoryMaterialToCategoryMaterialDtoConvertor;
    private final CategoryMaterialDtoToCategoryMaterialConvertor categoryMaterialDtoToCategoryMaterialConvertor;

    public CategoryMaterialServiceImpl(CategoryMaterialRepository categoryMaterialRepository, CategoryMaterialToCategoryMaterialDtoConvertor categoryMaterialToCategoryMaterialDtoConvertor, CategoryMaterialDtoToCategoryMaterialConvertor categoryMaterialDtoToCategoryMaterialConvertor) {
        this.categoryMaterialRepository = categoryMaterialRepository;
        this.categoryMaterialToCategoryMaterialDtoConvertor = categoryMaterialToCategoryMaterialDtoConvertor;
        this.categoryMaterialDtoToCategoryMaterialConvertor = categoryMaterialDtoToCategoryMaterialConvertor;
    }

    @Override
    public CategoryMaterialDto addCategoryMaterial(CategoryMaterialDto categoryMaterialDto) {
        CategoryMaterial categoryMaterial = categoryMaterialDtoToCategoryMaterialConvertor.convert(categoryMaterialDto);
        CategoryMaterial save = categoryMaterialRepository.save(categoryMaterial);
        return categoryMaterialToCategoryMaterialDtoConvertor.convert(save);
    }

    @Override
    public List<CategoryMaterialDto> getAllCategoryMaterials() {

        return categoryMaterialRepository.findAll()
                .stream()
                .map(categoryMaterialToCategoryMaterialDtoConvertor::convert)
                .toList();

    }


}
