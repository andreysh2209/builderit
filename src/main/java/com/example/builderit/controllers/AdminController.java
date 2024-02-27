package com.example.builderit.controllers;

import com.example.builderit.models.SubWorkGroup;
import com.example.builderit.models.WorkGroup;
import com.example.builderit.services.WorkGroupService;
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
    @PostMapping ("/addGroupWork")
    public WorkGroup addWorkGroup (@RequestBody WorkGroup workGroup) {
        return workGroupService.addWorkGroup(workGroup);

    }
    @PostMapping ("/addSubGroupWork")
    public SubWorkGroup addSubWorkGroup (@RequestBody SubWorkGroup subWorkGroup) {
        return null;

    }

}
