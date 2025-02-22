package com.bridgelabz.runtimeanalysisandbigonotation;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) temp[k++] = array[i++];
            else temp[k++] = array[j++];
        }

        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right], i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }

    public static void testSortingPerformance(int size) {
        Random random = new Random();
        int[] originalArray = new int[size];

        for (int i = 0; i < size; i++) {
            originalArray[i] = random.nextInt(size * 10);
        }

        int[] arrayBubble = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrayMerge = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrayQuick = Arrays.copyOf(originalArray, originalArray.length);

        long startTime, endTime;

        startTime = System.nanoTime();
        bubbleSort(arrayBubble);
        endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        startTime = System.nanoTime();
        mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;

        startTime = System.nanoTime();
        quickSort(arrayQuick, 0, arrayQuick.length - 1);
        endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ns");
        System.out.println("Merge Sort Time: " + mergeSortTime + " ns");
        System.out.println("Quick Sort Time: " + quickSortTime + " ns\n");
    }

    public static void main(String[] args) {
        testSortingPerformance(1_000);
        testSortingPerformance(10_000);
        testSortingPerformance(100_000);
    }
}

