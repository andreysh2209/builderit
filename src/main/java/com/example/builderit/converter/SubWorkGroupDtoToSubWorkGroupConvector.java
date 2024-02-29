package com.example.builderit.converter;

import com.example.builderit.dto.SubWorkGroupDto;
import com.example.builderit.models.SubWorkGroup;
import com.example.builderit.models.WorkGroup;
import com.example.builderit.repositories.WorkGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SubWorkGroupDtoToSubWorkGroupConvector extends Converter<SubWorkGroupDto,SubWorkGroup>{
    private final WorkGroupRepository workGroupRepository;
    @Override
    public SubWorkGroup convert(SubWorkGroupDto subWorkGroupDto) {
        SubWorkGroup subWorkGroup=new SubWorkGroup();
        subWorkGroup.setId(subWorkGroupDto.getId());
        subWorkGroup.setName(subWorkGroupDto.getName());
        subWorkGroup.setDescription(subWorkGroupDto.getDescription());
        Optional<WorkGroup> optionalWorkGroup = workGroupRepository.findById(subWorkGroupDto.getWorkGroupsId());
        if (optionalWorkGroup.isPresent()) {
            WorkGroup workGroup = optionalWorkGroup.get();
            subWorkGroup.setWorkGroup(workGroup);
        }
        return subWorkGroup;
    }
}
