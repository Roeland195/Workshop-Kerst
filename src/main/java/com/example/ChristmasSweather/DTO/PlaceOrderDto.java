package com.example.ChristmasSweather.DTO;

import com.example.ChristmasSweather.Models.Product;
import org.hibernate.criterion.Order;
import com.example.ChristmasSweather.Models.delivery;

import java.util.UUID;

public class PlaceOrderDto {
    private String id;
    private String userId;
    private double totalPrice;

    public PlaceOrderDto(){}

    public PlaceOrderDto(delivery order){
        this.id = UUID.randomUUID().toString();
        this.setId(order.getId());
        this.setUserId(order.getUserid());
        this.setTotalPrice(order.getTotalPrice());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
