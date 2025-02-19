package com.bridgelabz.datastructures.stackandqueue;

import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Remove smaller elements from the stack
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push the current index onto the stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        // Print result
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
