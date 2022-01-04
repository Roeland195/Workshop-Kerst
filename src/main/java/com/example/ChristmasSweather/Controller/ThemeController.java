package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThemeController {
    @Autowired
    private ThemeRepository themeRepository;
}
