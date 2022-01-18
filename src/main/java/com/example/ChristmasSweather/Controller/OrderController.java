package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.delivery;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Reposetory.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class OrderController {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @CrossOrigin(origins = "http://localhost:4200")
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
