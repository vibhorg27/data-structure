package com.bridgelabz.datastructures.stackandqueue;

import java.util.Stack;

class Operations{

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data){
        // push all elements from stack 1 to stack 2
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }

        // Add the element that is to be enqueued in the queue
        s1.push(data);

        // push all elements back from stack 2 to stack 1
        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public int dequeue(){
        if(s1.isEmpty()){
            return -1;
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }

    public void display(){
        System.out.println("Queue: " + s1);
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {
        Operations operation = new Operations();
        operation.enqueue(1);
        operation.enqueue(2);
        operation.enqueue(3);
        operation.enqueue(4);

        operation.display();

        operation.dequeue();

        operation.display();


    }

}
