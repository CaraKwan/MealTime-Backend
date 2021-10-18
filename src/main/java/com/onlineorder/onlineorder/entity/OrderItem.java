package com.onlineorder.onlineorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;  //avoid circular dependencies

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = -2455760938054036364L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //Automatically assign next available id
    private int id;
    private int quantity;
    private double price;

    //need to return MenuItem information when returning OrderItem
    @ManyToOne
    private MenuItem menuItem;

    @ManyToOne
    @JsonIgnore  //avoid circular dependencies
    private Cart cart;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}

