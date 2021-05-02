package com.example.coding.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检查锁
 *
 * @author liqingtai
 * @date 2020-08-09
 */
public class IdGeneratorV3 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV3 instance;

    public static IdGeneratorV3 getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorV3.class) {
                if (instance == null) {
                    instance = new IdGeneratorV3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    private IdGeneratorV3() {

    }
}
