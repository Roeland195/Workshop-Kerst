package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class ShoppingCart {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToMany(targetEntity = Product.class)
    private Set<Product> products = new HashSet<>();

    protected ShoppingCart(){}

    public ShoppingCart(String id, Set<Product> products) {
        this.id = id;
        this.products = products;
    }

    public ShoppingCart(Set<Product> products) {
        this.products = products;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
