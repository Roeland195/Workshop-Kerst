package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.DAO.ProductDao;
import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/Product")
    public HTTPResponse getProduct(@RequestParam(name = "name", defaultValue = "") String name){
        return productDao.getProduct(name);
    }
    @PostMapping("/Product")
    public HTTPResponse addProduct(@RequestBody Product[] product){
        return productDao.addProduct(product[0]);
    }
    @PutMapping("/Product")
    public HTTPResponse changeProduct(@RequestBody Product[] product) {
        return productDao.changeProduct(product[0]);
    }
    @DeleteMapping("/Product")
    public HTTPResponse deleteProduct(@RequestBody Product[] product){
        return productDao.deleteProduct(product[0]);
    }
}