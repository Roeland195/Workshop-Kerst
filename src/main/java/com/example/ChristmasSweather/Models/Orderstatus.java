package com.example.ChristmasSweather.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Orderstatus {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "status")
    private String status;

    protected Orderstatus(){}

    public Orderstatus(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public Orderstatus(String status) {
        this.status = status;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
