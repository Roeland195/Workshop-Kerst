package com.example.ChristmasSweather.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Theme {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "theme")
    private String theme;

    protected Theme(){}

    public Theme(String id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Theme(String theme) {
        this.theme = theme;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
