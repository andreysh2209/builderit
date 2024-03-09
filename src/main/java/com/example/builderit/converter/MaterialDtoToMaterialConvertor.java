package com.example.builderit.converter;

import com.example.builderit.dto.MaterialDto;
import com.example.builderit.enums.MeasurementType;
import com.example.builderit.models.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class MaterialDtoToMaterialConvertor extends Converter<MaterialDto, Material> {
    @Override
    public Material convert(MaterialDto materialDto) {
        Material material = new Material();
        material.setId(materialDto.getId());
        material.setName(materialDto.getName());
        material.setCode(materialDto.getCode());
        MeasurementType type = Arrays.stream(MeasurementType.values())
                .filter(measurementType -> measurementType.getCode().equals(materialDto.getMeasurementType()))
                .findFirst()
                .orElse(MeasurementType.m2);
        material.setMeasurementType(type);
        material.setPrice(materialDto.getPrice());
        return material;
    }
}
