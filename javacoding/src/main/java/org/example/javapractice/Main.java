package org.example.javapractice;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++; // Critical section: shared resource access
            System.out.println(Thread.currentThread().getName() + " increments count to: " + count);
        } finally {
            lock.unlock(); // Release the lock in a finally block to ensure it always runs
        }
    }

    public int getCount() {
        // A lock can also be used here if reading the count needs synchronization
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // The final count will be reliable and consistent due to the lock
        System.out.println("Final count: " + counter.getCount());
    }
}
