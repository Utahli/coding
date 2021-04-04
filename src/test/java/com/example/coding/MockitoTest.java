package com.example.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author: liqingtai
 * @Email: liqingtaiabc@163.com
 * @DateTime: 2021/1/30 下午4:27
 */
@RunWith(SpringRunner.class)
public class MockitoTest {

    @Test
    public void confirmVehicle() {
        String param = null;
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

    @Test
    public void test() {
        List mockedList = mock(ArrayList.class);
        mockedList.add("once");
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //这里默认是判断该方法调用times(1),同下
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //从没调用，times(0)
        verify(mockedList, never()).add("never happened");

        //最少一次，最少几次，最多几次
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");

    }
}
