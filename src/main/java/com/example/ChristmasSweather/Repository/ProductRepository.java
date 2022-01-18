package com.example.ChristmasSweather.Repository;

import com.example.ChristmasSweather.Models.Product;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByName(String name);
}