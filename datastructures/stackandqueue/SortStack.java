package com.bridgelabz.datastructures.stackandqueue;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int top = stack.pop();

        sortStack(stack);
        insertSorted(stack, top);
    }

    public static void insertSorted(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek() <= element){
            stack.push(element);
            return;
        }

        int top = stack.pop();

        insertSorted(stack, element);
        stack.push(top);

    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(30);
        s.push(3);
        s.push(5);
        s.push(-3);
        s.push(14);
        s.push(18);

        System.out.println("Original Stack: " + s);

        sortStack(s);

        System.out.println("Sorted Stack: " + s);
    }
}
