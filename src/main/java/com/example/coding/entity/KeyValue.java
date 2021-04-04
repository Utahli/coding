package com.example.coding.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @Author: LQT
 * @DateTime: 2021/2/1
 */
@Slf4j
@Data
public class KeyValue {
    private String key;
    private String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public static void main(String[] args) {
//        List<KeyValue> l = new ArrayList<>();
//        l.add(new KeyValue("1", "1"));
//        l.add(new KeyValue("2", "2"));
//        l.add(new KeyValue("3", "3"));
//        l.add(new KeyValue("1", "2"));
//
//        Map<String, String> collect = l.stream().collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue, (k, v) -> v));
//        log.info("{}", collect);
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }

}
