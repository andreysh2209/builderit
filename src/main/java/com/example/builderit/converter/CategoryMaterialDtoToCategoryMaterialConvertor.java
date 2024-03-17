package com.example.builderit.converter;

import com.example.builderit.dto.CategoryMaterialDto;
import com.example.builderit.models.CategoryMaterial;
import org.springframework.stereotype.Component;

@Component
public class CategoryMaterialDtoToCategoryMaterialConvertor extends Converter <CategoryMaterialDto, CategoryMaterial> {
    @Override
    public CategoryMaterial convert(CategoryMaterialDto categoryMaterialDto) {
        CategoryMaterial categoryMaterial=new CategoryMaterial();
        categoryMaterial.setId(categoryMaterialDto.getId());
        categoryMaterial.setName(categoryMaterialDto.getName());
        categoryMaterial.setDescription(categoryMaterialDto.getDescription());
        return categoryMaterial;
    }
}
