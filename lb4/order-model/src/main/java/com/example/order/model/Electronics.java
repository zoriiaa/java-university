package com.example.order.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Electronics extends Product {
    private final String brand;
    private final int warrantyMonths;

    @Builder
    public Electronics(String name, double price, String brand, int warrantyMonths) {
        super(name, price);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
