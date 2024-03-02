package com.example.builderit.services;

import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.models.WorkGroup;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface WorkGroupService {
    List<WorkGroupDto> addWorkGroup(WorkGroup workGroup, MultipartFile file) throws IOException;

    List<WorkGroup> getAll();

    List<WorkGroupDto> getAllWorkGroups();
}
