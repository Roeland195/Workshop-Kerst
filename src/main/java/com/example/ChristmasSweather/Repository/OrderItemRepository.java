package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Orderitem, String> {
}
