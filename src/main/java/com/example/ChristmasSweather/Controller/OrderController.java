package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.delivery;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OrderController {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @PostMapping("/Wishlist")
    public HTTPResponse addOrder(@RequestBody Product[] products){

        Set<Product> articles = new HashSet<>();
       for (Product product : products) {
            articles.add(product);
        }

        delivery delivery = new delivery(
                products.length,
                articles,
                "In Behandeling");

       deliveryRepository.save(delivery);

        return HTTPResponse.<Product>returnSuccess(null);
    }
}
