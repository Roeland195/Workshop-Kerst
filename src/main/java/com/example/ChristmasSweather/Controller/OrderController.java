package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.DAO.OrderDao;
import com.example.ChristmasSweather.HTTPResponse;

import com.example.ChristmasSweather.RequestObject.ShoppingListRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/Orders")
    public HTTPResponse getOrder(@RequestParam(name = "name", defaultValue = "") String name){
        return orderDao.getOrder();
    }

    @PostMapping("/Wishlist")
    public HTTPResponse addOrder(@RequestBody ShoppingListRequestObject shoplist){
        System.out.println(shoplist);
        return orderDao.addOrder(shoplist);
    }
}
