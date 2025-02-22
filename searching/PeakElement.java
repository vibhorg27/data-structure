package com.bridgelabz.searching;

public class PeakElement {
    public static int findPeak(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 8, 12, 4, 2};
        System.out.println(findPeak(array));
    }
}
