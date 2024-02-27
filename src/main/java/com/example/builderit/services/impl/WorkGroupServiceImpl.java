package com.example.builderit.services.impl;

import com.example.builderit.models.WorkGroup;
import com.example.builderit.repositories.WorkGroupRepository;
import com.example.builderit.services.WorkGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkGroupServiceImpl implements WorkGroupService {

    private final WorkGroupRepository workGroupRepository;

    @Override
    public WorkGroup addWorkGroup(WorkGroup workGroup) {
        WorkGroup save = workGroupRepository.save(workGroup);
        return save;
    }

    @Override
    public List <WorkGroup> getAll() {
        List<WorkGroup> all = workGroupRepository.findAll();

        return all;
    }
}
