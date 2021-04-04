package com.example.coding.exercise;;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;

/**
 * @author liqingtai
 * @date 2020-09-15
 */
public class BeanCopyTest {
    public static void main(String[] args) throws JsonProcessingException {
        BeanCopyTest1 beanCopyTest1 = new BeanCopyTest1();
        beanCopyTest1.setOuterName("hahaha");
        beanCopyTest1.setInnerClass(new BeanCopyTest1.InnerClass("haha1"));
        beanCopyTest1.setInnerClassList(Arrays.asList(new BeanCopyTest1.InnerClass("haha2"), new BeanCopyTest1.InnerClass("haha3")));

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(String.format("test1: %s", objectMapper.writeValueAsString(beanCopyTest1)));

        BeanCopyTest2 beanCopyTest2 = new BeanCopyTest2();
        beanCopyTest2.setInnerClass(new BeanCopyTest2.InnerClass());
        BeanUtils.copyProperties(beanCopyTest1, beanCopyTest2);
        BeanUtils.copyProperties(beanCopyTest1.getInnerClass(), beanCopyTest2.getInnerClass());
        System.out.println(String.format("test1: %s", objectMapper.writeValueAsString(beanCopyTest2)));
    }
}
