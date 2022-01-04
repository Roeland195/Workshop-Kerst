package com.example.ChristmasSweather.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Address {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "addons")
    private String addons;

    protected Address(){}

    public Address(String id, String city, String country, String street, int number, String addons) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.addons = addons;
    }

    public Address(String city, String country, String street, int number, String addons) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.addons = addons;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }
}
