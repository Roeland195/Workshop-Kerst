package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.delivery;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Models.orderitem;
import com.example.ChristmasSweather.Repository.AccountRepository;
import com.example.ChristmasSweather.Repository.DeliveryRepository;
import com.example.ChristmasSweather.Repository.OrderItemRepository;
import com.example.ChristmasSweather.Repository.ProductRepository;
import com.example.ChristmasSweather.RequestObject.ShoppingListRequestObject;
import com.example.ChristmasSweather.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OrderController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderService orderService;


    @GetMapping("/Orders")
    public HTTPResponse getAllOrders(@RequestParam(name="name", defaultValue = "") String name){
        List<delivery> orderDtList = orderService.listOfOrders();
//        List<Product> orderDtList = productRepository.findAll();
        if(orderDtList.isEmpty()) {return null;}
        System.out.println(orderDtList.get(0));

        return HTTPResponse.<List<delivery>>returnSuccess(orderDtList);
    }

    @PostMapping("/Wishlist")
    public HTTPResponse addOrder(@RequestBody ShoppingListRequestObject shoppingList){
        double price = 0;
        int total =0;
       for (Product product : shoppingList.getProducts()) {
            price = price + product.getPrice();
            total = total+1;
       }
        Optional<Account> account = accountRepository.findByEmail(shoppingList.getUserId());
       orderService.placeOrder(shoppingList ,account.get().getId(),price,total);


        return HTTPResponse.<Product>returnSuccess(null);
    }
}
