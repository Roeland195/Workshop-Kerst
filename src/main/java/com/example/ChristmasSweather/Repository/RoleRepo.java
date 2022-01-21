package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, String> {
    Role findByName(String name);
}