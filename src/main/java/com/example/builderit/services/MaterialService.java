package com.example.builderit.services;

import com.example.builderit.dto.MaterialDto;
import com.example.builderit.enums.MeasurementType;

import java.util.List;

public interface MaterialService {
    List<String> getMeasurementTypes();

    MaterialDto addMaterial(MaterialDto materialDto);
}
