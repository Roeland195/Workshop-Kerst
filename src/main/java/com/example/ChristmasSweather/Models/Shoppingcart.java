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

    @ManyToMany(targetEntity = Article.class)
    private Set<Article> articles = new HashSet<>();

    protected Shoppingcart(){}

    public Shoppingcart(String id, Set<Article> articles) {
        this.id = id;
        this.articles = articles;
    }

    public Shoppingcart(Set<Article> articles) {
        this.articles = articles;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Article> getProducts() {
        return articles;
    }

    public void setProducts(Set<Article> articles) {
        this.articles = articles;
    }
}
