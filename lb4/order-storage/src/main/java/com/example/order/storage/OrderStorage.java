package com.example.order.storage;

import com.example.order.model.Order;
import com.example.order.model.Product;
import com.example.order.storage.internal.IdGenerator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class OrderStorage<T extends Product> {
    private final Map<Long, Order<T>> orders = new ConcurrentHashMap<>();
    private final IdGenerator idGenerator = new IdGenerator();

    public long nextId() {
        return idGenerator.next();
    }

    public void save(Order<T> order) {
        orders.put(order.getId(), order);
    }

    public Optional<Order<T>> findById(long id) {
        return Optional.ofNullable(orders.get(id));
    }

    public List<Order<T>> findBy(Predicate<Order<T>> filter) {
        return orders.values().stream().filter(filter).toList();
    }

    public int size() {
        return orders.size();
    }
}
