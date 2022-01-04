package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}