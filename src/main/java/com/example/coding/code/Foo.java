package com.example.coding.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author utah
 * @desc
 * @date 2021/5/16 11:16 下午
 */
public class Foo {

    private Lock lock1 = new ReentrantLock();
    private Condition condition1 = lock1.newCondition();
    private Condition condition2 = lock1.newCondition();

    private int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock1.lock();
        try {
            if (flag != 1) {
                condition1.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            condition1.signal();
        } finally {
            lock1.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock1.lock();
        try {
            if (flag != 2) {
                condition1.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            condition2.signal();
        } finally {
            lock1.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock1.lock();
        try {
            if (flag != 3) {
                condition2.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            condition1.signal();
        } finally {
            lock1.unlock();
        }
    }
}
