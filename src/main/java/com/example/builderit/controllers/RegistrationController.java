package com.example.builderit.controllers;

import com.example.builderit.dto.UserDto;
import com.example.builderit.services.impl.RegistrationServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class RegistrationController {

 private final RegistrationServiceImpl registrationService;

    public RegistrationController(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping ("/registration")

    public UserDto registration (@RequestBody UserDto userDto) {

        return registrationService.registratoon(userDto);
    }


}
