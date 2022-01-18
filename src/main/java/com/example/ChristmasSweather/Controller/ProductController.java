package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

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

    @PutMapping("/Product")
    public HTTPResponse changeProduct(@RequestBody Product[] products){
        Product newProduct = products[0];
        Optional<Product> old = productRepository.findById(newProduct.getId());

        if(old.isEmpty()){
            return HTTPResponse.<Product[]>returnFailure("could not find a product with id: " + newProduct.getId());
        }
        old.get().setName(newProduct.getName());
        old.get().setDescription(newProduct.getDescription());
        old.get().setPrice(newProduct.getPrice());
        old.get().setColor(newProduct.getColor());
        old.get().setAvalable(newProduct.isAvalable());
        old.get().setTotal(newProduct.getTotal());
        old.get().setSex(newProduct.getSex());
        old.get().setSize(newProduct.getSize());
        productRepository.save(old.get());

        return HTTPResponse.<Product>returnSuccess(old.get());
    }

    @DeleteMapping("/Product")
    public HTTPResponse deleteProduct(@RequestBody Product[] product){
        System.out.println(product);
        Optional<Product> prod = productRepository.findById(product[0].getId());
        if(prod.isEmpty()){
            return HTTPResponse.<Product[]>returnFailure("could not find a Product with id: " + product[0].getId());
        }
        productRepository.deleteById(prod.get().getId());
        return HTTPResponse.<Product>returnSuccess(prod.get());
    }
}
