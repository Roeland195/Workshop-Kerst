package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}