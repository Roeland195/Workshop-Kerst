package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, String> {
}