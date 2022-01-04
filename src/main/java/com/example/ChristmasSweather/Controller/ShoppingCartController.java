package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.ShoppingcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingcartRepository shoppingCartRepository;
}
