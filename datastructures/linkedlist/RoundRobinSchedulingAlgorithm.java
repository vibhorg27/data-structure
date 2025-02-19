package com.bridgelabz.datastructures.linkedlist;


class ProcessNode {
    int processID, burstTime, remainingTime, waitingTime, turnaroundTime;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initially, remaining time = burst time
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null, tail = null;

    // Add process to circular linked list
    public void addProcess(int processID, int burstTime) {
        ProcessNode newProcessNode = new ProcessNode(processID, burstTime);
        if (head == null) {
            head = newProcessNode;
            head.next = head; // Circular link
            tail = head;
        } else {
            tail.next = newProcessNode;
            newProcessNode.next = head; // Maintain circular structure
            tail = newProcessNode;
        }
    }

    // Remove process from circular linked list
    private void removeProcessByID(int processID) {
        if (head == null) return;

        ProcessNode current = head, prev = tail;
        do {
            if (current.processID == processID) {
                if (current == head && current == tail) {
                    head = tail = null; // Single node case
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate Round Robin CPU Scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;
        ProcessNode current = head;
        int elapsedTime = 0;

        System.out.println("Executing Processes:");
        while (head != null) {
            if (current.remainingTime > timeQuantum) {
                System.out.println("Process " + current.processID + " executed for " + timeQuantum + " units.");
                current.remainingTime -= timeQuantum;
                elapsedTime += timeQuantum;
            } else {
                System.out.println("Process " + current.processID + " completed execution.");
                elapsedTime += current.remainingTime;
                current.turnaroundTime = elapsedTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                totalWaitingTime += current.waitingTime;
                totalTurnaroundTime += current.turnaroundTime;
                totalProcesses++;

                ProcessNode temp = current;
                current = current.next;
                removeProcessByID(temp.processID);
                if (head == null) break;
                continue;
            }

            // Update waiting times for remaining processes
            ProcessNode temp = head;
            do {
                if (temp != current && temp.remainingTime > 0) {
                    temp.waitingTime += Math.min(timeQuantum, current.remainingTime);
                }
                temp = temp.next;
            } while (temp != head);

            current = current.next;
        }

        // Calculate and display averages
        if (totalProcesses > 0) {
            double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
            double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
            System.out.println("Average Waiting Time: " + avgWaitingTime);
            System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        }
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        scheduler.addProcess(4, 6);

        int timeQuantum = 4;
        scheduler.simulateRoundRobin(timeQuantum);
    }
}