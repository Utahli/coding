package com.example.coding.code;

/**
 * @author utah
 * @desc
 * @date 2021/5/25 10:43 下午
 */
public class Trap {
    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }

        int lMax = height[0];
        int rMax = height[length - 1];

        int l = 0;
        int r = length - 1;

        int res = 0;
        while (l <= r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if (lMax <= rMax) {
                res += lMax - height[l];
                l++;
            } else {
                res += rMax - height[r];
                r--;
            }
        }

        return res;
    }


    /**
     * 备忘录
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }

        int lMax = height[0];
        int rMax = height[length - 1];

        int[] lMaxMemo = new int[length];
        int[] rMaxMemo = new int[length];
        for (int i = 0; i < length; i++) {
            lMax = Math.max(lMax, height[i]);
            lMaxMemo[i] = lMax;
        }
        for (int i = length - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            rMaxMemo[i] = rMax;
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res += Math.min(lMaxMemo[i], rMaxMemo[i]) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int res = trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(res);
    }
}
