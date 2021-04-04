package com.example.coding;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/30 下午4:12
 */
@RunWith(Parameterized.class)
@Slf4j
public class UtTest {

    @Parameterized.Parameters(name = "{index}: addOne({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    @Parameterized.Parameter
    public int input;

    @Parameterized.Parameter(1)
    public int output;

    @Test
    public void test() {
        Assert.assertEquals(output, addOne(input));
    }

    private static int addOne(int a) {
        return a+1;
    }

}
