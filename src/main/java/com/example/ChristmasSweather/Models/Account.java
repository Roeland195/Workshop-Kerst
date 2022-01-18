package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(targetEntity = Address.class)
    private Set<Address> addresses = new HashSet<>();

    protected Account(){}

    public Account(String name, String email, String id, String password, Set<Address> addres){
        this.name = name;
        this.email = email;
        this.id = id;
        this.addresses = addres;
        this.password = password;
    }

    public Account(String name, String email, String password, Set<Address> addres){
        this.name = name;
        this.email = email;
        this.password = password;
        this.addresses = addres;
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

    public String getLogin() {
        return password;
    }

    public void setLogin(String password) {
        this.password = password;
    }
}