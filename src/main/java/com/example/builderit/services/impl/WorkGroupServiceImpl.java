package com.example.builderit.services.impl;

import com.example.builderit.converter.WorkGroupToWorkGroupDtoConvertor;
import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.models.Image;
import com.example.builderit.models.WorkGroup;
import com.example.builderit.repositories.WorkGroupRepository;
import com.example.builderit.services.WorkGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkGroupServiceImpl implements WorkGroupService {

    private final WorkGroupRepository workGroupRepository;
    private final WorkGroupToWorkGroupDtoConvertor workGroupToWorkGroupDtoConvertor;

    @Override
    public List<WorkGroupDto> addWorkGroup(WorkGroup workGroup, MultipartFile file) throws IOException {
        Image image = convert(file);
        image.setWorkGroup(workGroup);
        List<Image> images = new ArrayList<>();
        images.add(image);
        workGroup.setImages(images);
        workGroupRepository.save(workGroup);
        return getAllWorkGroups();
    }

    @Override
    public List<WorkGroup> getAll() {
        return workGroupRepository.findAll();
    }

    @Override
    public List<WorkGroupDto> getAllWorkGroups() {
        return getAll()
                .stream()
                .map(workGroupToWorkGroupDtoConvertor::convert)
                .toList();
    }

    private Image convert(MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setName(multipartFile.getName());
        image.setOriginalFileName(multipartFile.getOriginalFilename());
        image.setContentType(multipartFile.getContentType());
        image.setSize(multipartFile.getSize());
        image.setBytes(multipartFile.getBytes());
        return image;
    }
}
