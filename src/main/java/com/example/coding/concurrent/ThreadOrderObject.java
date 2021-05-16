package com.example.coding.concurrent;

/**
 * @author utah
 * @desc
 * @date 2021/5/15 6:19 下午
 */
public class ThreadOrderObject {
    public static Object lock = new Object();
    public static int count = 1;
    public static int end = 100;
    public static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (count < end) {
                synchronized (lock) {
                    if (flag != 0) {
                        System.out.println(Thread.currentThread().getName() + " not my turn");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "--->" + count++);
                    flag = 1;
                    lock.notify();
                }
            }
        }, "偶数线程");

        Thread thread2 = new Thread(() -> {
            while (count <= end) {
                synchronized (lock) {
                    if (flag != 1) {
                        System.out.println(Thread.currentThread().getName() + " not my turn");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "--->" + count++);
                    flag = 0;
                    lock.notify();
                }
            }
        }, "奇数线程");

        thread2.start();
        Thread.sleep(50);
        thread1.start();
    }
}
