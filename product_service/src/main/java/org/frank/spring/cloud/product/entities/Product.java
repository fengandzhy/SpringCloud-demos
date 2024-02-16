package org.frank.spring.cloud.product.entities;

import java.math.BigDecimal;

public class Product {
    
    private int id;
    private String name;
    private BigDecimal price;
    private int store;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}
