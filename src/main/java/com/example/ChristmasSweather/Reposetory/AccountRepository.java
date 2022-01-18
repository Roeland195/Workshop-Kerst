package com.example.ChristmasSweather.Reposetory;

import com.example.ChristmasSweather.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByName(String name);
    Optional<Account> findByEmail(String email);
}
