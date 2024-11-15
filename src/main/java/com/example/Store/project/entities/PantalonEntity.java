package com.example.Store.project.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "pantalones")
public class PantalonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    public PantalonEntity() {
    }

    public PantalonEntity(Long id, String size, String color, double price, int stock) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public PantalonEntity(String size, String color, double price, int stock) {
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
