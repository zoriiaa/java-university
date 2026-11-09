package com.example.order.model;

import lombok.Getter;

@Getter
public abstract class Product {
    private final String name;
    private final double price;

    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getCategory();
}
