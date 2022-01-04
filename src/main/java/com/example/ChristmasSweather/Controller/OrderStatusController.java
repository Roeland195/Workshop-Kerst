package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.OrderstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderStatusController {
    @Autowired
    private OrderstatusRepository orderstatusRepository;
}
