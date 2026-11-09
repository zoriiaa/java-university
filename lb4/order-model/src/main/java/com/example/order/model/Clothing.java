package com.example.order.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Clothing extends Product {
    private final String size;
    private final String material;
    private final String color;

    @Builder
    public Clothing(String name, double price, String size, String material, String color) {
        super(name, price);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}
