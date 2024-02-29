package com.example.builderit.controllers;

import com.example.builderit.dto.SubWorkGroupDto;
import com.example.builderit.models.SubWorkGroup;
import com.example.builderit.models.WorkGroup;
import com.example.builderit.services.WorkGroupService;
import com.example.builderit.services.impl.SubWorkGroupServiceImpl;
import com.example.builderit.services.impl.WorkGroupServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin("http://localhost:3000/")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private  final WorkGroupServiceImpl workGroupService;
    private final SubWorkGroupServiceImpl subWorkGroupService;
    @PostMapping ("/addGroupWork")
    public WorkGroup addWorkGroup (@RequestBody WorkGroup workGroup) {
        return workGroupService.addWorkGroup(workGroup);

    }
    @PostMapping ("/addSubGroupWork")
    public SubWorkGroupDto addSubWorkGroup (@RequestBody SubWorkGroupDto subWorkGroupDto) {
        return subWorkGroupService.addSubWorkGroup(subWorkGroupDto);

    }

}
