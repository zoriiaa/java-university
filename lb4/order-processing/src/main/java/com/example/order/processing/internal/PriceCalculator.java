package com.example.order.processing.internal;

import com.example.order.model.Order;
import com.example.order.model.Product;

public final class PriceCalculator {
    private PriceCalculator() {
    }

    public static double total(Order<? extends Product> order) {
        double base = order.getTotal();
        return order.getQuantity() >= 3 ? base * 0.9 : base;
    }
}
