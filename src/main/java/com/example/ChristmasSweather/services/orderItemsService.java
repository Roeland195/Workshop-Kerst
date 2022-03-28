package com.example.ChristmasSweather.services;

import com.example.ChristmasSweather.Repository.DeliveryRepository;
import com.example.ChristmasSweather.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ChristmasSweather.Models.orderitem;

@Service
public class orderItemsService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void addOrderedProducts(orderitem item){
        orderItemRepository.save(item);
    }


}
