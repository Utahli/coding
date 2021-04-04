package com.example.demo.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author liqingtai
 * @date 2020-08-09
 */
public class IdGeneratorV1 {
    private AtomicLong id = new AtomicLong(0);
    private static final IdGeneratorV1 instance = new IdGeneratorV1();

    public static IdGeneratorV1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    private IdGeneratorV1() {

    }
}
