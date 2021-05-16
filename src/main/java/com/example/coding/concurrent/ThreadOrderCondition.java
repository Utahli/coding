package com.example.coding.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author utah
 * @desc
 * @date 2021/5/15 6:19 下午
 */
public class ThreadOrderCondition {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static int count = 1;
    private static int end = 100;
    private static int flag = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (count < end) {
                lock.lock();

                try {
                    if (flag != 0) {
                        System.out.println(Thread.currentThread().getName() + "not my turn");
                        condition.await();
                    }

                    System.out.println(Thread.currentThread().getName() + "--->" + count++);
                    flag = 1;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "奇数线程");

        Thread thread2 = new Thread(() -> {
            while (count < end) {
                lock.lock();

                try {
                    if (flag != 1) {
                        System.out.println(Thread.currentThread().getName() + "not my turn");
                        condition.await();
                    }

                    System.out.println(Thread.currentThread().getName() + "--->" + count++);
                    flag = 0;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "偶数线程");

        thread1.start();
        thread2.start();
    }
}
