package com.example.ChristmasSweather.jwt;

public enum RoleNames {
    MOD("ADMIN"),
    USER("USER");
    private String value;

    RoleNames(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
