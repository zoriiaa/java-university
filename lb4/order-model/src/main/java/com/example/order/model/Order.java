package com.example.order.model;

import lombok.Getter;

@Getter
public class Order<T extends Product> {
    private final long id;
    private final T product;
    private final int quantity;

    public Order(long id, T product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("Order #%d [%s: %s, qty=%d, total=%.2f]",
                id, product.getCategory(), product.getName(), quantity, getTotal());
    }
}
