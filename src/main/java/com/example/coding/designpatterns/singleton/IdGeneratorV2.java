package com.example.coding.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒加载
 *
 * @author liqingtai
 * @date 2020-08-09
 */
public class IdGeneratorV2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV2 instance;

    public static synchronized IdGeneratorV2 getInstance() {
        if (instance == null) {
            instance = new IdGeneratorV2();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    private IdGeneratorV2() {

    }
}
