package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Shoppingcart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingcartRepository extends JpaRepository<Shoppingcart, String> {
}