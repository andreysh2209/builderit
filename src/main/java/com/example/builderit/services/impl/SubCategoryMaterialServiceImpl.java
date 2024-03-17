package com.example.builderit.services.impl;

import com.example.builderit.converter.SubCategoryMaterialDtoToSubCategoryMaterialConvertor;
import com.example.builderit.converter.SubCategoryMaterialToSubCategoryMaterialDtoConvertor;
import com.example.builderit.dto.SubCategoryMaterialDto;
import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.models.SubCategoryMaterial;
import com.example.builderit.repositories.CategoryMaterialRepository;
import com.example.builderit.repositories.SubCategoryMaterialRepository;
import com.example.builderit.services.SubCategoryMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoryMaterialServiceImpl implements SubCategoryMaterialService {
    private final SubCategoryMaterialDtoToSubCategoryMaterialConvertor subCategoryMaterialDtoToSubCategoryMaterialConvertor;
    private final SubCategoryMaterialToSubCategoryMaterialDtoConvertor subCategoryMaterialToSubCategoryMaterialDtoConvertor;
    private final SubCategoryMaterialRepository subCategoryMaterialRepository;
    @Override
    public SubCategoryMaterialDto addSubCategoryMaterial(SubCategoryMaterialDto subCategoryMaterialDto) {
        SubCategoryMaterial save = subCategoryMaterialRepository.save(subCategoryMaterialDtoToSubCategoryMaterialConvertor.convert(subCategoryMaterialDto));
        return subCategoryMaterialToSubCategoryMaterialDtoConvertor.convert(save);
    }
}
