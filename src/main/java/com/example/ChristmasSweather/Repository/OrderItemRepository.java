package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<orderitem, String> {
}
