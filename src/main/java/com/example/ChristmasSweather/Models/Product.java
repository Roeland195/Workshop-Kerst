package com.example.ChristmasSweather.Models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "color")
    private String color;

    @Column(name = "Avalable")
    private boolean Avalable;

    @Column(name = "image")
    private String image;

    @Column(name = "sex")
    private String sex;

    @Column(name = "size")
    private String size;

    @Column(name = "total")
    private int total;

    @ManyToMany(targetEntity = Theme.class)
    private Set<Theme> themes = new HashSet<>();

    protected Product(){}

    public Product(String id, int total, String name, String description, double price, String color, boolean avalable, String image, String sex, String size, Set<Theme> themes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.color = color;
        this.Avalable = avalable;
        this.total = total;
        this.image = image;
        this.sex = sex;
        this.size = size;
        this.themes = themes;
    }

    public Product(String name,int total , String description, double price, String color, boolean avalable, String image, String sex, String size, Set<Theme> themes) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.color = color;
        this.Avalable = avalable;
        this.total = total;
        this.image = image;
        this.sex = sex;
        this.size = size;
        this.themes = themes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvalable() {
        return Avalable;
    }

    public void setAvalable(boolean avalable) {
        Avalable = avalable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }
}