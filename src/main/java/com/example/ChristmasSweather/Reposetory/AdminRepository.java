package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}