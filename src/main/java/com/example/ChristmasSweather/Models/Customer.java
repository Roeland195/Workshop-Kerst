package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne(targetEntity = Login.class)
    private Login login;

    @OneToOne(targetEntity = Shoppingcart.class)
    private Shoppingcart shoppingCart;

    @ManyToMany(targetEntity = Address.class)
    private Set<Address> addresses = new HashSet<>();

    protected Customer(){}

    public Customer(String name, String email, String id){
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public Customer(String name, String email){
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Shoppingcart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Shoppingcart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}