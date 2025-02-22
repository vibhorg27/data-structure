package com.bridgelabz.runtimeanalysisandbigonotation;

import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void testPerformance(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }

        int target = array[random.nextInt(size)];

        long startTime, endTime;

        startTime = System.nanoTime();
        linearSearch(array, target);
        endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;

        Arrays.sort(array);

        startTime = System.nanoTime();
        binarySearch(array, target);
        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time: " + linearSearchTime + " ns");
        System.out.println("Binary Search Time: " + binarySearchTime + " ns");

        if(linearSearchTime > binarySearchTime) System.out.println("Binary Search is better\n");
        else System.out.println("Linear Search is better\n");
    }

    public static void main(String[] args) {
        testPerformance(10_000);
        testPerformance(100_000);
        testPerformance(1_000_000);
    }
}
