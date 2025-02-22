package com.bridgelabz.searching;

import java.util.Arrays;

public class SearchTargetSorted {
    public static int searchTarget(int[] array, int target) {
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 7, 5, 9};
        int target = 5;
        System.out.println(searchTarget(array, target));
    }
}
