package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "orderitems")
public class orderitem {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name ="product_id")
    private String product_id;

    @Column(name ="quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "order_id")
    private String order_id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false,updatable = false)
    private Product product;

    public orderitem(){}

    public orderitem(String order_id, String product_id, int quantity, double price){
        this.id = UUID.randomUUID().toString();
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
