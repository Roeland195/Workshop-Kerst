package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
}
