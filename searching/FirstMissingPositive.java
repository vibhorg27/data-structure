package com.bridgelabz.searching;

public class FirstMissingPositive {
    public static int findFirstMissingPositive(int[] array) {
        int n = array.length;
        boolean[] present = new boolean[n + 1];
        for (int num : array) {
            if (num > 0 && num <= n) present[num] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) return i;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        System.out.println(findFirstMissingPositive(array));
    }
}
