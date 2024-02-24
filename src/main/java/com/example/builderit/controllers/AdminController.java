package com.example.builderit.controllers;

import com.example.builderit.models.WorkGroup;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin("http://localhost:3000/")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @PostMapping ("/addGroupWork")
    public WorkGroup addWorkGroup (@RequestBody WorkGroup workGroup) {
        return new WorkGroup();

    }

}
