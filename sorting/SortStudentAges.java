package com.bridgelabz.sorting;
import java.util.Arrays;

public class SortStudentAges {
    public static void countingSort(int[] arr, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count the occurrences of each age
        for (int age : arr) {
            count[age - minAge]++;
        }

        // Compute cumulative frequency\
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in correct positions
        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy sorted output back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] ages = {15, 12, 17, 10, 14, 16, 18, 11, 13, 12, 14, 10, 18, 16};
        countingSort(ages, 10, 18);
        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }
}
