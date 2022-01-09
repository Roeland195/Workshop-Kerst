package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Reposetory.ShoppingcartRepository;
import com.example.ChristmasSweather.Models.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingcartRepository shoppingCartRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/Wishlist")
    public @ResponseBody
    String addProductToShoppingCart(@RequestBody Product product){
         Set<Product> Product = new HashSet<>();

        Product.add(product);
        Shoppingcart shoppingcart = new Shoppingcart(Product);

        shoppingCartRepository.save(shoppingcart);
        return "saved";
    }
}
