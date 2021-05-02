package com.example.coding.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举
 *
 * @author liqingtai
 * @date 2020-08-09
 */
public enum IdGeneratorV5 {
    /**
     * 单例枚举
     */
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

}
