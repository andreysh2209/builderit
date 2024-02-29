package com.example.builderit.services.impl;

import com.example.builderit.converter.SubWorkGroupDtoToSubWorkGroupConvector;
import com.example.builderit.converter.SubWorkGroupToSubWorkGroupDtoConvertor;
import com.example.builderit.dto.SubWorkGroupDto;
import com.example.builderit.models.SubWorkGroup;
import com.example.builderit.repositories.SubWorkGroupRepository;
import com.example.builderit.services.SubWorkGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubWorkGroupServiceImpl implements SubWorkGroupService {
    private final SubWorkGroupRepository subWorkGroupRepository;
    private final SubWorkGroupDtoToSubWorkGroupConvector subWorkGroupDtoToSubWorkGroupConvector;
    private final SubWorkGroupToSubWorkGroupDtoConvertor subWorkGroupToSubWorkGroupDtoConvertor;
    @Override
    public SubWorkGroupDto addSubWorkGroup(SubWorkGroupDto subWorkGroupDto) {
        SubWorkGroup convert = subWorkGroupDtoToSubWorkGroupConvector.convert(subWorkGroupDto);
        SubWorkGroup save = subWorkGroupRepository.save(convert);
        SubWorkGroupDto subWorkGroupDtoResult = subWorkGroupToSubWorkGroupDtoConvertor.convert(save);
        return subWorkGroupDtoResult;
    }
}
