package com.example.ChristmasSweather.RequestObject;

import com.example.ChristmasSweather.Models.Product;

public class ShoppingListRequestObject {
    private Product[] products;
    private String userId;

    public ShoppingListRequestObject(){}

    public ShoppingListRequestObject(Product[] products, String userId){
        this.products = products;
        this.userId = userId;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
