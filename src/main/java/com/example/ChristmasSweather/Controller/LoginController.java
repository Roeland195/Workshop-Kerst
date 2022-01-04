package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;
}
