package com.example.builderit.converter;

import com.example.builderit.dto.SubCategoryMaterialDto;
import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.models.SubCategoryMaterial;
import com.example.builderit.repositories.CategoryMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubCategoryMaterialDtoToSubCategoryMaterialConvertor extends Converter<SubCategoryMaterialDto, SubCategoryMaterial>{
    private final CategoryMaterialRepository categoryMaterialRepository;
    @Override
    public SubCategoryMaterial convert(SubCategoryMaterialDto subCategoryMaterialDto) {
        SubCategoryMaterial subCategoryMaterial=new SubCategoryMaterial();
        subCategoryMaterial.setId(subCategoryMaterialDto.getId());
        subCategoryMaterial.setName(subCategoryMaterialDto.getName());
        subCategoryMaterial.setDescription(subCategoryMaterialDto.getDescription());
        subCategoryMaterial.setCategoryMaterial(categoryMaterialRepository.findById(subCategoryMaterialDto.getCategoryMaterialId()).orElse(null));
        return subCategoryMaterial;
    }
}
