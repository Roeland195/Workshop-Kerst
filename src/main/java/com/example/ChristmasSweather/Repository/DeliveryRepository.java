package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {
}