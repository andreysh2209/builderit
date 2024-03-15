package com.example.builderit.converter;

import com.example.builderit.dto.MaterialDto;
import com.example.builderit.models.SubCategoryMaterial;
import com.example.builderit.dto.SubCategoryMaterialDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubCategoryMaterialToSubCategoryMaterialDtoConvertor extends Converter<SubCategoryMaterial, SubCategoryMaterialDto> {
private final MaterialToMaterialDtoConvertor materialToMaterialDtoConvertor;

    public SubCategoryMaterialToSubCategoryMaterialDtoConvertor(MaterialToMaterialDtoConvertor materialToMaterialDtoConvertor) {
        this.materialToMaterialDtoConvertor = materialToMaterialDtoConvertor;
    }

    @Override
    public SubCategoryMaterialDto convert(SubCategoryMaterial subCategoryMaterial) {
        SubCategoryMaterialDto subCategoryMaterialDto = new SubCategoryMaterialDto();
        subCategoryMaterialDto.setId(subCategoryMaterial.getId());
        subCategoryMaterialDto.setName(subCategoryMaterial.getName());
        subCategoryMaterialDto.setDescription(subCategoryMaterial.getDescription());
        List<MaterialDto> materialDtos = subCategoryMaterial.getMaterials()
                .stream()
                .map(materialToMaterialDtoConvertor::convert)
                .toList();
        subCategoryMaterialDto.setMaterialDto(materialDtos);
        subCategoryMaterialDto.setCategoryMaterialId(subCategoryMaterial.getCategoryMaterial().getId());
        return subCategoryMaterialDto;

    }
}


//public SubWorkGroupDto convert(SubWorkGroup subWorkGroup) {
//    SubWorkGroupDto subWorkGroupDto=new SubWorkGroupDto();
//    subWorkGroupDto.setId(subWorkGroup.getId());
//    subWorkGroupDto.setName(subWorkGroup.getName());
//    subWorkGroupDto.setDescription(subWorkGroup.getDescription());
//    subWorkGroupDto.setWorkGroupsId(subWorkGroup.getWorkGroup().getId());
//    return subWorkGroupDto;
//}