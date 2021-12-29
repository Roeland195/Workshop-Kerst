package com.example.ChristmasSweather.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;

    @Column(name = "desc")
    private String desc;

    @Column(name = "available")
    private boolean available;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "sex")
    private String sex;

    @Column(name = "totalInStorage")
    private int totalInStorage;

    protected Product(){}

    public Product(String id, String name, String image, double price, String desc, boolean available, String size, String color, String sex, int totalInStorage) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.desc = desc;
        this.available = available;
        this.size = size;
        this.color = color;
        this.sex = sex;
        this.totalInStorage = totalInStorage;
    }

    public Product(String name, String image, double price, String desc, boolean available, String size, String color, String sex, int totalInStorage) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.desc = desc;
        this.available = available;
        this.size = size;
        this.color = color;
        this.sex = sex;
        this.totalInStorage = totalInStorage;
        this.id = UUID.randomUUID().toString();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTotalInStorage() {
        return totalInStorage;
    }

    public void setTotalInStorage(int totalInStorage) {
        this.totalInStorage = totalInStorage;
    }
}
