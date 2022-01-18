package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.ERole;
import com.example.ChristmasSweather.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
