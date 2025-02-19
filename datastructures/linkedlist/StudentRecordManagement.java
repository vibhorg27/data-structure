package com.bridgelabz.datastructures.linkedlist;

import java.sql.SQLOutput;

class StudentNode{
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade ){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList{
//  adding at the first position
    private StudentNode head;
    public void addAtStart(int rollNumber, String name, int age, String grade){
        StudentNode newStudentNode = new StudentNode(rollNumber, name, age, grade);
        if(head == null){
            head = newStudentNode;
            return;
        }
        newStudentNode.next = head;
        head = newStudentNode;
    }

//  Adding at last position
    public void addAtEnd(int rollNumber, String name, int age, String grade){
        StudentNode newStudentNode = new StudentNode(rollNumber, name, age, grade);
        if(head == null){
            head = newStudentNode;
            return;
        }
        StudentNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newStudentNode;
    }

//  Adding at a particular position
    public void addAtPosition(int rollNumber, String name, int age, String grade, int position){
        StudentNode newStudentNode = new StudentNode(rollNumber, name, age, grade);
        if(position <= 1){
            addAtStart(rollNumber, name, age, grade);
            return;
        }
        StudentNode temp = head;
        for (int i = 0; temp != null && i< position-1 ; i++) {
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Invalid  position");
            return;
        }

        newStudentNode.next = temp.next;
        temp.next = newStudentNode;
    }

//  Delete a record by roll number
    public void deleteByRollNumber(int rollNumberToDelete){
        if(head == null){
            System.out.println("List is empty");
        }

        if(head.rollNumber == rollNumberToDelete){
            head = head.next;
        }

        StudentNode temp = head, prev = null;
            while(temp != null && temp.rollNumber != rollNumberToDelete){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;

    }

    public void searchByRollNumber(int rollNumberToSearch){
        if(head == null){
            System.out.println("List is empty");
        }

        StudentNode temp = head;
        while(temp != null){
            if(temp.rollNumber == rollNumberToSearch){
                System.out.println("Student found!!!");
            }
            temp = temp.next;
        }


    }

    public void updateGrade(int rollNumber, String newGrade){
        if(head == null){
            System.out.println("List is empty");
        }
        StudentNode temp = head;
        while(temp != null){
            if(temp.rollNumber == rollNumber){
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
    }


//  Method to print the LL
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        StudentNode temp = head;
        System.out.println("\nStudent Records:");
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        studentList.addAtStart(1, "V", 4, "A");
        studentList.addAtStart(2, "D", 4, "A");
        studentList.addAtStart(3, "W", 4, "A");

        studentList.displayStudents();
        studentList.deleteByRollNumber(2);
        studentList.displayStudents();

        studentList.searchByRollNumber(1);
        studentList.updateGrade(1, "B");
        studentList.displayStudents();


    }
}
