package com.bridgelabz.sorting;

import java.util.Arrays;

public class SortEmployeeId {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i;

            while(j>0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8,2,65,23,56,23,4,2,5,2,56,8};
        insertionSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
