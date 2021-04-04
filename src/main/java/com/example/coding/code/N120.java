package com.example.coding.code;;

import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/27 上午9:06
 */
public class N120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }

        // base case
        dp.get(0).add(0, triangle.get(0).get(0));
        dp.get(1).add(0, dp.get(0).get(0) + triangle.get(1).get(0));
        dp.get(1).add(1, dp.get(0).get(0) + triangle.get(1).get(1));

        for (int i = 2; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp.get(i).add(j, triangle.get(i).get(j) + dp.get(i - 1).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    dp.get(i).add(j, triangle.get(i).get(j) + dp.get(i - 1).get(j - 1));
                } else {
                    dp.get(i).add(j, triangle.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (Integer integer : dp.get(triangle.size() - 1)) {
            res = Math.min(res, integer);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,3));

        N120 n120 = new N120();
        int minimumTotal = n120.minimumTotal(lists);
        System.out.println(minimumTotal);
    }
}
