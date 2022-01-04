package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {
}