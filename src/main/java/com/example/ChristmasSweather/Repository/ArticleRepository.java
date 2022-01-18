package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Product, String> {
}