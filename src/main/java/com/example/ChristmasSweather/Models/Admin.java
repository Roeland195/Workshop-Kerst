package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Admin {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @OneToOne(targetEntity = Login.class)
    private Login login;

    protected Admin(){}

    public Admin(String name, String id){
        this.name = name;
        this.id = id;
    }

    public Admin(String name){
        this.name = name;
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
