package com.example.ChristmasSweather.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Login {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    protected Login(){}

    public Login(String password){
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
