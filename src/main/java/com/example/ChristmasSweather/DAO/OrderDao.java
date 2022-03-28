package com.example.ChristmasSweather.DAO;

import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.Delivery;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Repository.AccountRepository;
import com.example.ChristmasSweather.RequestObject.ShoppingListRequestObject;
import com.example.ChristmasSweather.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDao {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OrderService orderService;

    public OrderDao(){}

    public HTTPResponse getOrder(){
        List<Delivery> deliveries = orderService.listOfOrders();
        if(deliveries.isEmpty()){return HTTPResponse.returnFailure("NO ORDERS WHERE FOUND");}

        return HTTPResponse.returnSuccess(deliveries);
    }

    public HTTPResponse addOrder(ShoppingListRequestObject shoppingList){
        double price = 0;
        int total = 0;
        for(Product product : shoppingList.getProducts()){
            price = price + product.getPrice();
            total = total+1;
        }
        Optional<Account> account = accountRepository.findByEmail(shoppingList.getUserId());
        orderService.placeOrder(shoppingList, account.get().getId(),price,total);

        return HTTPResponse.returnSuccess("Order has been placed");
    }
}
