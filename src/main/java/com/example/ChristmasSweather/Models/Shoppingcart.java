package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Shoppingcart {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToMany(targetEntity = Product.class)
    private Set<Product> articles = new HashSet<>();

    protected Shoppingcart(){}

    public Shoppingcart(String id, Set<Product> articles) {
        this.id = id;
        this.articles = articles;
    }

    public Shoppingcart(Set<Product> articles) {
        this.articles = articles;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return articles;
    }

    public void setProducts(Set<Product> articles) {
        this.articles = articles;
    }
}
