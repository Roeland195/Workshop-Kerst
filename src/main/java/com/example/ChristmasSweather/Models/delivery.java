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

    @Column(name = "status")
    private String status;

    @ManyToMany(targetEntity = Product.class)
    private Set<Product> articles = new HashSet<>();

    protected delivery(){}

    public delivery(int totalAmount, String id, Set<Product> articles, String status){
        this.totalAmount = totalAmount;
        this.articles = articles;
        this.id = id;
        this.status = status;
    }

    public delivery(int totalAmount, Set<Product> articles, String status){
        this.totalAmount = totalAmount;
        this.articles = articles;
        this.status = status;
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

    public String getStatusID() {
        return status;
    }

    public void setStatusID(String statusID) {
        this.status = statusID;
    }

    public Set<Product> getArticles() {
        return articles;
    }

    public void setArticles(Set<Product> articles) {
        this.articles = articles;
    }
}
