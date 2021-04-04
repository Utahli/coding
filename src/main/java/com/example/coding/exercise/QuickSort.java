package com.example.coding.exercise;;

/**
 * @Author: LQT
 * @DateTime: 2021/3/12
 */
public class QuickSort {
    static void quickSort(int n[], int left, int right) {
        if (left >= right) {
            return;
        }
        int dp = partition(n, left, right);
        quickSort(n, left, dp - 1);
        quickSort(n, dp + 1, right);
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot) {
                right--;
            }
            if (left < right) {
                n[left++] = n[right];
            }
            while (left < right && n[left] <= pivot) {
                left++;
            }
            if (left < right) {
                n[right--] = n[left];
            }
        }
        n[left] = pivot;
        return left;
    }
}
