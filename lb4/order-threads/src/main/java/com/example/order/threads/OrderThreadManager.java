package com.example.order.threads;

import com.example.order.model.Order;
import com.example.order.model.Product;
import com.example.order.processing.OrderProcessingException;
import com.example.order.processing.OrderProcessor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class OrderThreadManager<T extends Product> {
    private final OrderProcessor<T> processor;
    private final ExecutorService executor;

    public OrderThreadManager(OrderProcessor<T> processor, int threads) {
        this.processor = processor;
        AtomicInteger counter = new AtomicInteger();
        this.executor = Executors.newFixedThreadPool(threads,
                task -> new Thread(task, "order-worker-" + counter.incrementAndGet()));
    }

    public void submit(Order<T> order) {
        executor.submit(() -> processor.process(order));
    }

    public void submitAll(List<Order<T>> orders) {
        orders.forEach(this::submit);
    }

    public void submitFiltered(List<Order<T>> orders, Predicate<Order<T>> filter) {
        orders.stream().filter(filter).forEach(this::submit);
    }

    public void submitRaw(Order<?> order) {
        executor.submit(() -> {
            try {
                processor.processRaw(order);
            } catch (OrderProcessingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        });
    }

    public void awaitCompletion() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
