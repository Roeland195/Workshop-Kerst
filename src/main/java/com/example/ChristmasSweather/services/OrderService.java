package com.example.ChristmasSweather.services;

import com.example.ChristmasSweather.DTO.PlaceOrderDto;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Models.Delivery;
import com.example.ChristmasSweather.Models.orderitem;
import com.example.ChristmasSweather.Repository.DeliveryRepository;
import com.example.ChristmasSweather.Repository.OrderItemRepository;
import com.example.ChristmasSweather.RequestObject.ShoppingListRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private orderItemsService orderItemsService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void placeOrder(ShoppingListRequestObject shoppingList, String userId, double totalPrice, int total){
        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setUserId(userId);
        placeOrderDto.setTotalPrice(totalPrice);
        String orderId = saveOrder(placeOrderDto, userId, total);

        for (Product product : shoppingList.getProducts()) {
            orderitem orderitem = new orderitem(orderId, product.getId(),product.getTotal(),product.getPrice());
            orderItemsService.addOrderedProducts(orderitem);
        }
    }

    public String saveOrder(PlaceOrderDto orderDto, String userId, int total){


        Delivery delivery = new Delivery(orderDto,"IN BEHANDELING" ,userId, total);
                return deliveryRepository.save(delivery).getId();
    }

    public List<Delivery> listOfOrders(){

        List<Delivery> data = deliveryRepository.findAll();
        return deliveryRepository.findAll();
    }

    public void deleteallOrders(){
        orderItemRepository.deleteAll();
        deliveryRepository.deleteAll();
    }
}
