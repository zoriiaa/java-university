package com.example.order.app;

import com.example.order.model.Clothing;
import com.example.order.model.Electronics;
import com.github.javafaker.Faker;

public class DataGenerator {
    private final Faker faker = new Faker();

    public Electronics electronics() {
        return Electronics.builder()
                .name(faker.commerce().productName())
                .price(faker.number().randomDouble(2, 100, 2000))
                .brand(faker.company().name())
                .warrantyMonths(faker.number().numberBetween(6, 37))
                .build();
    }

    public Clothing clothing() {
        return Clothing.builder()
                .name(faker.commerce().productName())
                .price(faker.number().randomDouble(2, 10, 300))
                .size(faker.options().option("S", "M", "L", "XL"))
                .material(faker.commerce().material())
                .color(faker.color().name())
                .build();
    }
}
