package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Order {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "TotalAmount")
    private int totalAmount;

    @OneToOne(targetEntity = OrderStatus.class)
    private OrderStatus orderStatus;

    @ManyToMany(targetEntity = Product.class)
    private Set<Product> producten = new HashSet<Product>();

    protected Order(){}

    public Order(int totalAmount, String id){
        this.totalAmount = totalAmount;
        this.id = id;
    }

    public Order(int totalAmount){
        this.totalAmount = totalAmount;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<Product> getProducten() {
        return producten;
    }

    public void setProducten(Set<Product> producten) {
        this.producten = producten;
    }
}
