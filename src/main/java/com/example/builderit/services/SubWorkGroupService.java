package com.example.builderit.services;

import com.example.builderit.dto.SubWorkGroupDto;

import java.util.List;

public interface SubWorkGroupService {
    SubWorkGroupDto addSubWorkGroup(SubWorkGroupDto subWorkGroupDto);

    List<SubWorkGroupDto> getSubWorkGroupsByWorkGroup(Long workGroupId);
}
