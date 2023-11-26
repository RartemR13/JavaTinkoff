package edu.hw7;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class Task1 {
    private Task1() {
    }

    public static int concGet() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1000; ++j) {
                    counter.getAndAdd(1);
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return counter.get();
    }
}
