package com.example.builderit.services.impl;

import com.example.builderit.converter.MaterialDtoToMaterialConvertor;
import com.example.builderit.converter.MaterialToMaterialDtoConvertor;
import com.example.builderit.dto.MaterialDto;
import com.example.builderit.enums.MeasurementType;
import com.example.builderit.models.Material;
import com.example.builderit.repositories.MaterialRepository;
import com.example.builderit.services.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialDtoToMaterialConvertor materialDtoToMaterialConvertor;
    private final MaterialToMaterialDtoConvertor materialToMaterialDtoConvertor;
    private final MaterialRepository materialRepository;

    @Override
    public List<String> getMeasurementTypes() {
        return Arrays
                .stream(MeasurementType.values())
                .map(measurementType -> measurementType.getCode())
                .toList();
    }

    @Override
    public MaterialDto addMaterial(MaterialDto materialDto) {
        Material save = materialRepository.save(materialDtoToMaterialConvertor.convert(materialDto));
        return materialToMaterialDtoConvertor.convert(save);
    }
}
