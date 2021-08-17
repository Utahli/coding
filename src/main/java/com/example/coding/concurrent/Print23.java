package com.example.coding.concurrent;

import lombok.SneakyThrows;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author utah
 * @desc
 * @date 2021/6/13 12:23 下午
 */
public class Print23 {
    public static Deque<Integer> queue = new LinkedList<>();

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition notEmpty = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    lock.lock();
                    try {
                        queue.offerLast(i);
                        notEmpty.signal();
                        Thread.sleep(100);
                    } finally {
                        lock.unlock();
                    }
                }

                while (true) {
                    if (queue.isEmpty()) {
                        break;
                    }

                    lock.lock();
                    try {
                        notEmpty.signal();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }, "A");


        Thread B = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (queue.isEmpty() || queue.peekFirst() % 2 != 0) {
                            notEmpty.await();
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + queue.pollFirst());
                        if (!queue.isEmpty()) {
                            notEmpty.signal();
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "B");

        Thread C = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (queue.isEmpty() || queue.peekFirst() % 3 != 0) {
                            notEmpty.await();
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + queue.pollFirst());
                        if (!queue.isEmpty()) {
                            notEmpty.signal();
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "C");

        Thread D = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (queue.isEmpty() || queue.peekFirst() % 2 == 0 || queue.peekFirst() % 3 == 0) {
                            notEmpty.await();
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + queue.pollFirst());
                        if (!queue.isEmpty()) {
                            notEmpty.signal();
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "D");

        A.start();
        B.start();
        C.start();
        D.start();

        A.join();
        Thread.sleep(1000);
        System.out.println("end");
    }
}
