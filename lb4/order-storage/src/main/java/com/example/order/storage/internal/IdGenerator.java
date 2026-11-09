package com.example.order.storage.internal;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private final AtomicLong counter = new AtomicLong();

    public long next() {
        return counter.incrementAndGet();
    }
}
