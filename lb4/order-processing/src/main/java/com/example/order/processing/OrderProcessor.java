package com.example.order.processing;

import com.example.order.model.Order;
import com.example.order.model.Product;
import com.example.order.processing.internal.PriceCalculator;
import com.example.order.storage.OrderStorage;

import java.util.function.Function;

public class OrderProcessor<T extends Product> {
    private final Class<T> type;
    private final OrderStorage<T> storage;
    private final Function<Order<T>, Double> priceCalculator;

    public OrderProcessor(Class<T> type, OrderStorage<T> storage) {
        this(type, storage, PriceCalculator::total);
    }

    public OrderProcessor(Class<T> type, OrderStorage<T> storage, Function<Order<T>, Double> priceCalculator) {
        this.type = type;
        this.storage = storage;
        this.priceCalculator = priceCalculator;
    }

    public Order<T> createOrder(T product, int quantity) {
        return new Order<>(storage.nextId(), product, quantity);
    }

    public void process(Order<T> order) {
        double total = priceCalculator.apply(order);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        storage.save(order);
        System.out.printf("[%s] Processed %s, final price %.2f%n",
                Thread.currentThread().getName(), order, total);
    }

    public void processRaw(Order<?> order) throws OrderProcessingException {
        try {
            T product = type.cast(order.getProduct());
            process(new Order<>(order.getId(), product, order.getQuantity()));
        } catch (ClassCastException e) {
            throw new OrderProcessingException("Order " + order.getId() + " has wrong product type: "
                    + order.getProduct().getClass().getSimpleName()
                    + ", expected: " + type.getSimpleName(), e);
        }
    }
}
