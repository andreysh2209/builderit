package com.example.builderit.services;

import com.example.builderit.models.WorkGroup;

import java.util.List;

public interface WorkGroupService {
    WorkGroup addWorkGroup(WorkGroup workGroup);

    List<WorkGroup> getAll();
}
