package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<delivery, String> {
}