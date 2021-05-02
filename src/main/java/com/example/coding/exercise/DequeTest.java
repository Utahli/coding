package com.example.coding.exercise;;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author liqingtai
 * @date 2020-10-27
 */
@Slf4j
public class DequeTest {
    public static void test1() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addFirst(1);
        queue.addLast(-1);
        log.info("{}", queue);
        queue.offerFirst(2);
        queue.offerLast(-2);
        log.info("{}", queue);
        queue.add(3);
        log.info("{}", queue);
        queue.offer(-3);
        log.info("{}", queue);
        Integer poll = queue.poll();
        log.info("{},{}", queue, poll);
        Integer pop = queue.pop();
        log.info("{},{}", queue, pop);
    }

    /**
     * 队列
     */
    public static void test2() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while (queue.peek() != null) {
            log.info("{}", queue.poll());
        }
    }

    /**
     * 栈
     */
    public static void test3() {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        log.info("{}",stack.peek());
        while (stack.peek() != null) {
            log.info("{}", stack.pop());
        }
    }

    /**
     * 双端队列
     */
    public static void test4() {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(1);
        queue.add(1);

        queue.add(-1);
        queue.addFirst(-1);
        queue.addLast(-1);
        queue.offer(-2);
        queue.offerLast(-2);

        log.info("{}",queue.pollFirst());
        log.info("{}",queue.pollLast());

    }

    public static void main(String[] args) {
//        DequeTest.test1();
//        DequeTest.test2();
        DequeTest.test4();
    }
}
