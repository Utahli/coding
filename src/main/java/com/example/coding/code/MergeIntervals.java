package com.example.coding.code;

import java.util.*;

/**
 * @author utah
 * @desc
 * @date 2021/6/13 12:25 下午
 */
public class MergeIntervals {
    public int[][] test(int[][] nums) {
        if (nums.length == 1) {
            return nums;
        }

        SortedMap<Integer, Integer> sorted = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            sorted.put(nums[i][0], i);
        }

        Integer[] ids = sorted.values().toArray(new Integer[]{new Integer(0)});

        List<List<Integer>> res = new ArrayList<>();
        int start = nums[ids[0]][0];
        int end = nums[ids[0]][1];
        for (int i = 1; i < ids.length; i++) {
            if (nums[ids[i]][0] > end) {
                res.add(Arrays.asList(start, end));
                start = nums[ids[i]][0];
                end = nums[ids[i]][1];
            } else if (nums[ids[i]][1] >= end) {
                end = nums[ids[i]][1];
            }
        }

        res.add(Arrays.asList(start, end));

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).get(0) + "-" + res.get(i).get(1));
        }

        int[][] rest = new int[res.size()][2];
//        res.
        return nums;
    }

    //[[1,4],[4,5],[3,10],[10,10],[13,21]]
//    [[1,3],[2,6],[8,10],[15,18]]
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.test(new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18},
        });
    }
}
