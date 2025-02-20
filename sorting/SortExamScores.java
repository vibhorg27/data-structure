package com.bridgelabz.sorting;

import java.util.Arrays;

public class SortExamScores {
    public static void selectionSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n ; i++) {
            int mini = i;
            for(int j = i ; j < n ; j ++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,7,4,7,8,4,3,89,3};
        selectionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
