package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Customer;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Models.Shoppingcart;
import com.example.ChristmasSweather.Models.Theme;
import com.example.ChristmasSweather.Reposetory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/Product")
    public HTTPResponse addScore(@RequestBody Product[] products){
        Product product = products[0];
        return HTTPResponse.<Product>returnSuccess(product);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping("/Product")
//    public @ResponseBody
//    String addNewProduct(@RequestParam Boolean avalable,
//                         @RequestParam String color,
//                         @RequestParam String description,
//                         @RequestParam String image,
//                         @RequestParam String name,
//                         @RequestParam double price,
//                         @RequestParam String sex,
//                         @RequestParam String size,
//                         @RequestParam int    total,
//                         @RequestParam Set<Theme> themes
//
//                         ){
//
//        Product product = new Product(name,total,description,price,color,avalable,image,sex,size,themes);
//        productRepository.save(product);
//        return "saved";
//    }

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
