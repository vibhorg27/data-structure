package com.bridgelabz.searching;


public class FirstNegativeNumber {
    public static int findFirstNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, -2, 7, -1, 8};
        System.out.println(findFirstNegative(array));
    }
}

