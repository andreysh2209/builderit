package com.example.builderit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstController {

    @GetMapping("/first")
    public  String firstms () {
        return  "Hello world";
    }
    @GetMapping("/second")
    public  String second () {
        return  "Hello world again";
    }
}
