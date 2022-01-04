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

    @OneToOne(targetEntity = Orderstatus.class)
    private Orderstatus orderStatus;

    @ManyToMany(targetEntity = Article.class)
    private Set<Article> articles = new HashSet<>();

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

    public Orderstatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Orderstatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<Article> getProducts() {
        return articles;
    }

    public void setProducts(Set<Article> articles) {
        this.articles = articles;
    }
}
