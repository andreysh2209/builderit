package com.example.builderit.converter;

import com.example.builderit.dto.MaterialDto;
import com.example.builderit.models.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MaterialToMaterialDtoConvertor extends Converter<Material, MaterialDto> {

    @Override
    public MaterialDto convert(Material material) {
        MaterialDto materialDto=new MaterialDto();
        materialDto.setId(material.getId());
        materialDto.setName(material.getName());
        materialDto.setCode(material.getCode());
        materialDto.setPrice(material.getPrice());
        materialDto.setMeasurementType(material.getMeasurementType().getCode());
        return materialDto;

    }
}
