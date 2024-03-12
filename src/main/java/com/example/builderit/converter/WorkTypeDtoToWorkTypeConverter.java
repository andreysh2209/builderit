package com.example.builderit.converter;

import com.example.builderit.dto.MaterialDto;
import com.example.builderit.dto.WorkTypeDto;
import com.example.builderit.models.Material;
import com.example.builderit.models.WorkType;
import com.example.builderit.models.WorkTypeMaterials;
import com.example.builderit.repositories.SubWorkGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkTypeDtoToWorkTypeConverter extends Converter<WorkTypeDto, WorkType>{
    private final SubWorkGroupRepository subWorkGroupRepository;
    private final MaterialDtoToMaterialConvertor materialDtoToMaterialConvertor;
    @Override
    public WorkType convert(WorkTypeDto workTypeDto) {
        WorkType workType=new WorkType();
        workType.setId(workTypeDto.getId());
        workType.setName(workTypeDto.getName());
        workType.setCode(workTypeDto.getCode());
        workType.setSubWorkGroup(subWorkGroupRepository.findById(workTypeDto.getSubWorkGroupId()).orElse(null));

        List<WorkTypeMaterials> workTypeMaterials=new ArrayList<>();
        for (MaterialDto materialDto : workTypeDto.getMaterials()) {
            Material material = materialDtoToMaterialConvertor.convert(materialDto);
            WorkTypeMaterials workTypeMaterial=new WorkTypeMaterials();
            workTypeMaterial.setWorkType(workType);
            workTypeMaterial.setMaterial(material);
            workTypeMaterial.setQuantity(materialDto.getQnt());
            workTypeMaterials.add(workTypeMaterial);
        }
        workType.setWorkTypeMaterials(workTypeMaterials);
        workType.setDepreciationOfMachines(workTypeDto.getLaborHour().getDepreciationOfMachines());
        workType.setLaborHourOfWorker(workTypeDto.getLaborHour().getLaborHourOfWorker());
        workType.setLaborHourOfMachinist(workTypeDto.getLaborHour().getLaborHourOfMachinist());


        return workType;
    }
}
