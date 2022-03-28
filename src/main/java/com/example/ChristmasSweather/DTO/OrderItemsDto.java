package com.example.ChristmasSweather.DTO;

import com.example.ChristmasSweather.Models.Orderitem;

public class OrderItemsDto {
    private double price;
    private int quantity;
    private String orderId;
    private String productId;

    public OrderItemsDto(double price, int quantity, String  orderId, String productId){
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void addOrderedProducts(Orderitem orderitem) {
    }
}
