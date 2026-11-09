package com.example.order.app;

import com.example.order.model.Clothing;
import com.example.order.model.Electronics;
import com.example.order.model.Order;
import com.example.order.processing.OrderProcessor;
import com.example.order.storage.OrderStorage;
import com.example.order.threads.OrderThreadManager;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataGenerator generator = new DataGenerator();
        Random random = new Random();

        OrderStorage<Electronics> electronicsStorage = new OrderStorage<>();
        OrderStorage<Clothing> clothingStorage = new OrderStorage<>();

        OrderProcessor<Electronics> electronicsProcessor =
                new OrderProcessor<>(Electronics.class, electronicsStorage);
        OrderProcessor<Clothing> clothingProcessor =
                new OrderProcessor<>(Clothing.class, clothingStorage);

        List<Order<Electronics>> electronicsOrders = Stream.generate(generator::electronics)
                .limit(6)
                .map(product -> electronicsProcessor.createOrder(product, random.nextInt(4) + 1))
                .toList();

        List<Order<Clothing>> clothingOrders = Stream.generate(generator::clothing)
                .limit(6)
                .map(product -> clothingProcessor.createOrder(product, random.nextInt(4) + 1))
                .toList();

        OrderThreadManager<Electronics> electronicsManager =
                new OrderThreadManager<>(electronicsProcessor, 3);
        OrderThreadManager<Clothing> clothingManager =
                new OrderThreadManager<>(clothingProcessor, 2);

        electronicsManager.submitFiltered(electronicsOrders, order -> order.getTotal() > 300);
        clothingManager.submitAll(clothingOrders);
        electronicsManager.submitRaw(clothingOrders.get(0));

        electronicsManager.awaitCompletion();
        clothingManager.awaitCompletion();

        System.out.println("Electronics orders saved: " + electronicsStorage.size());
        System.out.println("Clothing orders saved: " + clothingStorage.size());

        System.out.println("Clothing orders with quantity above 1:");
        clothingStorage.findBy(order -> order.getQuantity() > 1).forEach(System.out::println);
    }
}
