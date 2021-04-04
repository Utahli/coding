package com.example.coding.code;;

/**
 * @Author: LQT
 * @DateTime: 2021/2/13
 */
public class N796 {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
