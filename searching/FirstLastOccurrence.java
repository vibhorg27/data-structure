package com.bridgelabz.searching;

public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] array, int target) {
        int left = 0, right = array.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) right = mid - 1;
            else left = mid + 1;
            if (array[mid] == target) result = mid;
        }
        return result;
    }

    public static int findLastOccurrence(int[] array, int target) {
        int left = 0, right = array.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) left = mid + 1;
            else right = mid - 1;
            if (array[mid] == target) result = mid;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 4, 4, 7, 9, 10};
        int target = 4;
        System.out.println(findFirstOccurrence(array, target) + " " + findLastOccurrence(array, target));
    }
}
