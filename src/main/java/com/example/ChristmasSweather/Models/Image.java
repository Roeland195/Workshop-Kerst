package com.example.ChristmasSweather.Models;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "image")
@Entity
public class Image {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "image_part")
    private String image_part;

    @Column(name = "image_order")
    private int image_order;

    @Column(name = "productid")
    private String productid;

    protected Image(){}

    public Image(String id, String image_part, int image_order,String  productid ){
        this.id = id;
        this.image_part = image_part;
        this.image_order = image_order;
        this.productid = productid;
    }

    public Image(String image_part, int image_order,String  productid ){
        this.id = UUID.randomUUID().toString();
        this.image_part = image_part;
        this.image_order = image_order;
        this.productid = productid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_part() {
        return image_part;
    }

    public void setImage_part(String image_part) {
        this.image_part = image_part;
    }

    public int getImage_order() {
        return image_order;
    }

    public void setImage_order(int image_order) {
        this.image_order = image_order;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
}
