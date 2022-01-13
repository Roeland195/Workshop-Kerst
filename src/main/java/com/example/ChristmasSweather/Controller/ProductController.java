package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Reposetory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/Product")
    public HTTPResponse addScore(@RequestBody Product[] products){
        String name = products[0].getName();
        String description = products[0].getDescription();
        double price = products[0].getPrice();
        String color = products[0].getColor();
        boolean avalable = products[0].isAvalable();
        int total = products[0].getTotal();
        String image = products[0].getImage();
        String sex = products[0].getSex();
        String size = products[0].getSize();


        Product product = new Product(name, total, description, price, color, avalable, image, sex, size);
        productRepository.save(product);
        return HTTPResponse.<Product>returnSuccess(product);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/Product")
    public Iterable<Product> getAllProducts(@RequestParam(name="name", defaultValue = "") String name){
        if(!name.equals("")){
            List<Product> data = productRepository.findByName(name);
            return data;
        }
        List<Product> data = productRepository.findAll();
        if(data.isEmpty()) {return null;}
        return data;
    }
}
