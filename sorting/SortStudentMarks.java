package com.bridgelabz.sorting;

import java.util.Arrays;

public class SortStudentMarks {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n -1; i++){
            for(int j = 0; j < n-1 ; j++){
                if(arr[j] > arr[j+1]){
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8,2,65,23,56,23,4,2,5,2,56,8};
        bubbleSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
