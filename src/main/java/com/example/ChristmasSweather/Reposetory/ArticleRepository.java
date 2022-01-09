package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Product, String> {
}