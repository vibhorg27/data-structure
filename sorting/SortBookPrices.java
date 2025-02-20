package com.bridgelabz.sorting;

import java.util.Arrays;

public class SortBookPrices {
    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] ans = new int[right - left + 1];

        int n1 = left;
        int n2 = mid+1;
        int index = 0;

        while(n1 <= mid && n2 <= right){
            if(arr[n1] <= arr[n2]){
                ans[index++] = arr[n1++];
            }
            else{
                ans[index++] = arr[n2++];
            }
        }

        // if one of the array is finished
        while(n1 <= mid){
            ans[index++] = arr[n1++];
        }

        while(n2 <= right){
            ans[index++] = arr[n2++];
        }

        for(int i = 0, j = left; i < ans.length; i++, j++){
            arr[j] = ans[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {8,2,65,23,56,23,4,2,5,2,56,8};
        int n = array.length;
        mergeSort(array, 0, n-1);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
