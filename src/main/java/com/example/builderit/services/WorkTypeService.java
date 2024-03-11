package com.example.builderit.services;

import com.example.builderit.dto.MaterialDto;
import com.example.builderit.dto.WorkTypeDto;

public interface WorkTypeService {
    MaterialDto addWorkType(WorkTypeDto workTypeDto);
}
