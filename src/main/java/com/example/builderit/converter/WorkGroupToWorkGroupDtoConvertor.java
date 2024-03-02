package com.example.builderit.converter;

import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.models.WorkGroup;
import org.springframework.stereotype.Component;

@Component
public class WorkGroupToWorkGroupDtoConvertor extends Converter<WorkGroup, WorkGroupDto>{
    @Override
    public WorkGroupDto convert(WorkGroup workGroup) {
        WorkGroupDto workGroupDto=new WorkGroupDto();
        workGroupDto.setId(workGroup.getId());
        workGroupDto.setName(workGroup.getName());
        workGroupDto.setDescription((workGroup.getDescription()));
        if(workGroup.getImages().size()>0){
            workGroupDto.setImageId(workGroup.getImages().get(0).getId());
        }
        return workGroupDto;
    }
}
