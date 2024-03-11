package com.example.builderit.controllers;

import com.example.builderit.dto.SubWorkGroupDto;
import com.example.builderit.dto.WorkGroupDto;
import com.example.builderit.services.impl.SubWorkGroupServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public/workGroup")
@CrossOrigin("http://localhost:3000/")
public class SubWorkPublicController {
    private final SubWorkGroupServiceImpl subWorkGroupService;


    @GetMapping("/{workGroupId}")
    public ResponseEntity<List<SubWorkGroupDto>> getSubWorkGroupsByWorkGroup (@PathVariable Long workGroupId) {
        return ResponseEntity.ok(subWorkGroupService.getSubWorkGroupsByWorkGroup(workGroupId));
    }
}
