package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByName(String name);
}
