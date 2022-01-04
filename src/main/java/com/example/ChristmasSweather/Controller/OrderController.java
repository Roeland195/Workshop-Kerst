package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private DeliveryRepository deliveryRepository;
}
