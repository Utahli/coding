package com.example.coding.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author utah
 * @desc
 * @date 2021/5/15 4:30 下午
 */
public class ThreadOrderSemaphore {
    private static Semaphore semaphore = new Semaphore(1);

    public static int count = 1;
    public static int end = 100;
    public static int flag = 0;


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (count < end) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (flag != 0) {
                    System.out.println(Thread.currentThread().getName() + " not my turn");
                } else {
                    System.out.println(Thread.currentThread().getName() + "--->" + count++);
                    flag = 1;
                }
                semaphore.release();
            }
        }, "奇数线程");


        Thread thread2 = new Thread(() -> {
            while (count < end) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (flag != 1) {
                    System.out.println(Thread.currentThread().getName() + " not my turn");
                } else {
                    System.out.println(Thread.currentThread().getName() + "--->" + count++);
                    flag = 0;
                }
                semaphore.release();
            }
        }, "偶数线程");

        thread1.start();
        thread2.start();
    }
}
