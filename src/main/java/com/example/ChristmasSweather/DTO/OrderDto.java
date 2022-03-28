package com.example.ChristmasSweather.DTO;

import com.example.ChristmasSweather.Models.delivery;

public class OrderDto {
    private String id;
    private String userId;

    public OrderDto(delivery order){
        this.setId(order.getId());
        this.setUserId(order.getUserid());
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
}
