package com.bridgelabz.datastructures.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] array, int k){
        int n = array.length;
        int[] max = new int[n-k+1];
        int r = 0; // this is the right pointer to add in the max array

        // creating a deque to store index
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {
            // remove numbers that are not in the window
            while(!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }

            // to maintain an ascending order of the values in the queue
            while(!q.isEmpty() && array[q.peekLast()] <= array[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i >= k-1){
                max[r++] = array[q.peek()];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-1, 3, 1, 5, 6, 8, 4};
        int[] ans = maxSlidingWindow(array, 3);

        System.out.println(Arrays.toString(ans));
    }


}
