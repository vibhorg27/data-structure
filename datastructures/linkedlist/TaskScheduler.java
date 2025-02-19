package com.bridgelabz.datastructures.linkedlist;

class TaskNode{
    String taskId;
    String taskName;
    String priority;
    String dueDate;
    TaskNode next;

    TaskNode(String taskId, String taskName, String priority, String dueDate){
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskLinkedList{
    private TaskNode head;
    private TaskNode currentTask;
    public void addAtStart(String taskId, String taskName, String priority, String dueDate){
        TaskNode newTaskNode = new TaskNode(taskId, taskName, priority, dueDate);
        if(head == null){
            head = newTaskNode;
            newTaskNode.next = head;
        }
        else{
            TaskNode temp = head;
            while(temp.next != head){  // traverse till the last node
                temp = temp.next;
            }
            newTaskNode.next = head;   // point the new node to the head node
            temp.next = newTaskNode;   // point the last node to the new node
            head = newTaskNode;        // update the head to new node
        }
    }

    public void addAtEnd(String taskId, String taskName, String priority, String dueDate){
        TaskNode newTaskNode = new TaskNode(taskId, taskName, priority, dueDate);
        if(head == null){
            head = newTaskNode;
            newTaskNode.next = head;
        }
        else{
            TaskNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newTaskNode;
            newTaskNode.next = head;

        }
    }

    public void addAtPosition(String taskId, String taskName, String priority, String dueDate, int position){
        TaskNode newTaskNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        if(head == null || position == 1){
            addAtStart(taskId, taskName, priority, dueDate);
            return;
        }

        for (int i = 0; temp.next != head && i < position -1 ; i++) {
            temp = temp.next;
        }

        if(temp.next == head){
            addAtEnd(taskId, taskName, priority, dueDate);
            return;
        }

        newTaskNode.next = temp.next;
        temp.next = newTaskNode;

    }

    public void removeTask(String taskId){
        if(head == null){
            System.out.println("No Tasks available");
            return;
        }

        TaskNode temp = head, prev = null;


        if (head.taskId.equals(taskId)) {
            if (head.next == head) { // Only one node
                head = null;
                return;
            }
            // Find the last node
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
            return;
        }

        // Find the node to delete
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && !temp.taskId.equals(taskId));

        if (temp == head) {
            System.out.println("Task not found.");
            return;
        }

        prev.next = temp.next;
    }


    public void viewAndMoveToNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        if (currentTask == null) {
            currentTask = head;
        }

        System.out.println("Current Task: " + currentTask.taskName);
        currentTask = currentTask.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority.equals(priority)) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }


}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskLinkedList taskLinkedList = new TaskLinkedList();

        taskLinkedList.addAtStart("a001", "update navbar", "3", "3/4/25");
        taskLinkedList.addAtEnd("a002", "Bug fix", "2", "2/3/25");
        taskLinkedList.addAtEnd("a003", "Code Review", "2", "2/3/25");
        taskLinkedList.addAtEnd("a004", "Risk mitigation", "2", "2/3/25");
        taskLinkedList.addAtEnd("a005", "Analyzing Customer feedback", "2", "2/3/25");

        taskLinkedList.displayAllTasks();
        System.out.println();

        taskLinkedList.addAtPosition("a006", "Customer Support", "2", "2/3/25", 3);
        taskLinkedList.displayAllTasks();
        System.out.println();

        taskLinkedList.removeTask("a002");
        taskLinkedList.displayAllTasks();
        System.out.println();

        taskLinkedList.searchByPriority("2");
    }
}
