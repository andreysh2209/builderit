package com.example.builderit.controllers;

import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.services.WorkGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public/workGroup")
@CrossOrigin("http://localhost:3000/")
public class WorkGroupPublicController {
    private final WorkGroupService workGroupService;
    @GetMapping
    public ResponseEntity<List<WorkGroupDto>> workGroups () {
       return ResponseEntity.ok(workGroupService.getAllWorkGroups());
    }
}
