package com.bridgelabz.searching;

public class RotationPoint {
    public static int findRotationPoint(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {7, 9, 11, 12, 5, 6};
        System.out.println(findRotationPoint(array));
    }
}

