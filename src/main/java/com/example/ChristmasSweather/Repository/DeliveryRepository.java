package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Models.delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<delivery, String> {
}