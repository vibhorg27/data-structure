package com.bridgelabz.sorting;


import java.util.Arrays;

public class SortBySalary {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {

            heapify(arr, n, i);
        }

        // Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index 'i'
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Assume root is the largest
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {50000, 75000, 60000, 45000, 90000, 80000, 55000};
        heapSort(salaries);
        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));
    }
}

