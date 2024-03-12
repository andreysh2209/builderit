package com.example.builderit.services.impl;

import com.example.builderit.converter.MaterialDtoToMaterialConvertor;
import com.example.builderit.converter.WorkTypeDtoToWorkTypeConverter;
import com.example.builderit.dto.LaborHourDto;
import com.example.builderit.dto.WorkTypeDto;
import com.example.builderit.models.WorkType;
import com.example.builderit.repositories.WorkTypeRepository;
import com.example.builderit.services.WorkTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorkTypeServiceImpl implements WorkTypeService {

    private final WorkTypeDtoToWorkTypeConverter workTypeDtoToWorkTypeConverter;
    private  final WorkTypeRepository workTypeRepository;

    @Override
    public WorkTypeDto addWorkType(WorkTypeDto workTypeDto) {

        WorkType convert = workTypeDtoToWorkTypeConverter.convert(workTypeDto);
        WorkType save=workTypeRepository.save(convert);
        return null;
    }
}
