package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, String> {

}