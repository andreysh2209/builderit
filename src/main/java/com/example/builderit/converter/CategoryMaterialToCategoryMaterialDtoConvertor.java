package com.example.builderit.converter;

import com.example.builderit.dto.CategoryMaterialDto;
import com.example.builderit.dto.MaterialDto;
import com.example.builderit.dto.SubCategoryMaterialDto;
import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.models.SubCategoryMaterial;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryMaterialToCategoryMaterialDtoConvertor extends Converter <CategoryMaterial, CategoryMaterialDto>{
    private final SubCategoryMaterialToSubCategoryMaterialDtoConvertor subCategoryMaterialToSubCategoryMaterialDtoConvertor;

    public CategoryMaterialToCategoryMaterialDtoConvertor(SubCategoryMaterialToSubCategoryMaterialDtoConvertor subCategoryMaterialToSubCategoryMaterialDtoConvertor) {
        this.subCategoryMaterialToSubCategoryMaterialDtoConvertor = subCategoryMaterialToSubCategoryMaterialDtoConvertor;
    }

    @Override
    public CategoryMaterialDto convert(CategoryMaterial categoryMaterial) {
        CategoryMaterialDto categoryMaterialDto=new CategoryMaterialDto();
        categoryMaterialDto.setId(categoryMaterial.getId());
        categoryMaterialDto.setName(categoryMaterial.getName());
        categoryMaterialDto.setDescription(categoryMaterialDto.getName());
        List<SubCategoryMaterialDto> subCategoryMaterials = categoryMaterial.getSubCategoryMaterials()
                .stream()
                .map(subCategoryMaterialToSubCategoryMaterialDtoConvertor::convert)
                .toList();
        categoryMaterialDto.setSubCategoryMaterialDto(subCategoryMaterials);

        return categoryMaterialDto;
    }
}
