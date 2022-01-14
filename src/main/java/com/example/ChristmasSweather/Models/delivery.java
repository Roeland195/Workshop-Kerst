package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class delivery {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "TotalAmount")
    private int totalAmount;

    @ManyToMany(targetEntity = Product.class)
    private Set<Product> articles = new HashSet<>();

    protected delivery(){}

    public delivery(int totalAmount, String id){
        this.totalAmount = totalAmount;
        this.articles = articles;
        this.id = id;
    }

    public delivery(int totalAmount){
        this.totalAmount = totalAmount;
        this.articles = articles;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<Product> getProducts() {
        return articles;
    }

    public void setProducts(Set<Product> articles) {
        this.articles = articles;
    }
}
