package com.example.demo.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类
 *
 * @author liqingtai
 * @date 2020-08-09
 */
public class IdGeneratorV4 {
    private AtomicLong id = new AtomicLong(0);

    private static class SingletonHolder {
        private static final IdGeneratorV4 instance = new IdGeneratorV4();
    }

    public static IdGeneratorV4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    private IdGeneratorV4() {

    }
}
