package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
    Image deleteByProductid(String id);
}
