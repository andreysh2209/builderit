package com.example.builderit.services;

import com.example.builderit.dto.MaterialDto;

import java.util.List;

public interface MaterialService {
    List<String> getMeasurementTypes();

    MaterialDto addMaterial(MaterialDto materialDto);


    List <MaterialDto> getMaterials();
}
