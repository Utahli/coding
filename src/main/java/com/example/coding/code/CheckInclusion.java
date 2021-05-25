package com.example.coding.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author utah
 * @desc
 * @date 2021/5/17 9:41 下午
 */
public class CheckInclusion {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; ++i) {
                --cnt[s1.charAt(i) - 'a'];
                ++cnt[s2.charAt(i) - 'a'];
            }
            int diff = 0;
            for (int c : cnt) {
                if (c != 0) {
                    ++diff;
                }
            }
            if (diff == 0) {
                return true;
            }
            for (int i = n; i < m; ++i) {
                int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
                if (x == y) {
                    continue;
                }
                if (cnt[x] == 0) {
                    ++diff;
                }
                ++cnt[x];
                if (cnt[x] == 0) {
                    --diff;
                }
                if (cnt[y] == 0) {
                    ++diff;
                }
                --cnt[y];
                if (cnt[y] == 0) {
                    --diff;
                }
                if (diff == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean checkInclusion1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }


    public boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int valid = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            r++;

            if (need.getOrDefault(c, 0) > 0) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            if (r - l > s1.length()) {
                char d = s2.charAt(l);
                l++;
                if (need.getOrDefault(d, 0) > 0) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

            if (valid == need.size()) {
                return true;
            }
        }

        return false;
    }
}
