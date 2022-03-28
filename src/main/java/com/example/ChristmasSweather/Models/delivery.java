package com.example.ChristmasSweather.Models;

import com.example.ChristmasSweather.DTO.PlaceOrderDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class delivery {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userid;

    @Column(name = "TotalAmount")
    private int totalAmount;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status")
    private String status;

    @OneToMany(targetEntity = orderitem.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Set<orderitem> orderItems;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Account account;

    protected delivery(){}

    public delivery( String id,String status,PlaceOrderDto orderDto, String userid){
        this.id = id;
        this.userid = userid;
        this.status = status;
        this.totalPrice = orderDto.getTotalPrice();
    }

    public delivery(PlaceOrderDto orderDto,String status, String userid, int total){
        this.id = UUID.randomUUID().toString();
        this.userid = userid;
        this.status = status;
        this.totalAmount = total;
        this.totalPrice = orderDto.getTotalPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatusID() {
        return status;
    }

    public void setStatusID(String statusID) {
        this.status = statusID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<orderitem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<orderitem> orderItems) {
        this.orderItems = orderItems;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
