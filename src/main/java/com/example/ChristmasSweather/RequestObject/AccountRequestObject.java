package com.example.ChristmasSweather.RequestObject;

public class AccountRequestObject {
    private String id;
    private String name;
    private String email;
    private String password;
    private String country;
    private String city;
    private String street;
    private int number;
    private String extra;


    public AccountRequestObject(String name, String email, String password, String country, String city, String street, int number, String extra) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.extra = extra;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
