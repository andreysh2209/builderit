package com.example.builderit.converter;

import com.example.builderit.dto.SubWorkGroupDto;
import com.example.builderit.models.SubWorkGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubWorkGroupToSubWorkGroupDtoConvertor extends Converter <SubWorkGroup, SubWorkGroupDto>{


    @Override
    public SubWorkGroupDto convert(SubWorkGroup subWorkGroup) {
        SubWorkGroupDto subWorkGroupDto=new SubWorkGroupDto();
        subWorkGroupDto.setId(subWorkGroup.getId());
        subWorkGroupDto.setName(subWorkGroup.getName());
        subWorkGroupDto.setDescription(subWorkGroup.getDescription());
        subWorkGroupDto.setWorkGroupsId(subWorkGroup.getWorkGroup().getId());
        return subWorkGroupDto;
    }

}
