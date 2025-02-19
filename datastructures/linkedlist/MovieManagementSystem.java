package com.bridgelabz.datastructures.linkedlist;

import java.util.Objects;

class MovieNode{
    String movieTitle;
    String director;
    int yearOfRelease;
    float rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String movieTitle, String director, int yearOfRelease ,float rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;

    }
}

class MovieLinkedList{
    private MovieNode head;
    private MovieNode tail;
    public void addAtStart(String movieTitle, String director, int yearOfRelease ,float rating){
        MovieNode newMovieNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if(head == null){
            head = tail = newMovieNode;
            return;
        }
        newMovieNode.next = head;
        head.prev = newMovieNode;
        head = newMovieNode;
    }

    public void addAtEnd(String movieTitle, String director, int yearOfRelease ,float rating){
        MovieNode newMovieNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if(head == null){
            head = newMovieNode;
            tail = newMovieNode;
            return;
        }
        tail.next = newMovieNode;
        newMovieNode.prev = tail;
        tail = newMovieNode;
    }


    public void addAtPosition(String movieTitle, String director, int yearOfRelease ,float rating, int position){
        MovieNode newMovieNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if(position == 1){
            addAtStart(movieTitle, director, yearOfRelease, rating);
            return;
        }
        MovieNode temp = head;

        for(int i = 1; temp != null && i < position-1; i++){
            temp = temp.next;


        }
        if(temp == null){
            addAtEnd(movieTitle, director, yearOfRelease, rating);
            return;
        }
        if(temp.next != null){
            newMovieNode.next = temp.next;
            temp.next = newMovieNode;
            newMovieNode.prev = temp;
            temp.next.prev = newMovieNode;
        }
        else{
            newMovieNode.prev = temp;
            temp.next = newMovieNode;
            tail = newMovieNode;
        }

    }

    public void removeMovie(String movieTitle){
        if(head == null){
            System.out.println("Invalid movie");
            return;
        }
        if(head.movieTitle.equals(movieTitle)){
            head = head.next;
            if (head != null) {
                head.prev = null;
            }else tail = null;
            return;
        }

        MovieNode temp = head;
        while(temp != null && !temp.movieTitle.equals(movieTitle)){
            temp = temp.next;
        }

        // If movie not found

        if(temp == null){
            System.out.println("Movie not found");
            return;
        }

        if(temp == tail){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        System.out.println("Movie removed");

    }

    public void searchByDirector(String director){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head.director.equals(director)){
            System.out.println("Director found");
        }

        boolean directorFound = false;
        MovieNode temp = head;
        while(temp != null){
            if(temp.director.equals(director)){
                directorFound = true;
            }
            temp = temp.next;

        }
        if(directorFound){
            System.out.println("Director found");
        }
        else System.out.println("Director Not found");

    }

    public void searchByRating(float rating){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head.rating == rating){
            System.out.println("Movie found");
        }

        boolean found = false;
        MovieNode temp = head;
        while(temp != null){
            if(temp.rating == rating){
                found = true;
            }
            temp = temp.next;

        }
        if(found){
            System.out.println("Movie found");
        }
        else System.out.println("Movie Not found");

    }

    public void updateRating(String movieTitle, float newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.movieTitle.equalsIgnoreCase(movieTitle)) {
                temp.rating = newRating;
                System.out.println("Rating updated for \"" + movieTitle + "\".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.print(temp.movieTitle + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.print(temp.movieTitle + " <--> ");
            temp = temp.prev;
        }
        System.out.println("null");

    }

    public void printList() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }
        MovieNode temp = head;
        System.out.println("Movie List:");
        while (temp != null) {
            System.out.println("Title: " + temp.movieTitle);
            System.out.println("Director: " + temp.director);
            System.out.println("Year of Release: " + temp.yearOfRelease);
            System.out.println("Rating: " + temp.rating);
            System.out.println("----------------------");
            temp = temp.next;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList mll = new MovieLinkedList();
        mll.addAtStart("Jai", "Horner", 2009, 3.4f);
        mll.addAtEnd("Veer", "Nolan", 1993, 5f);
        mll.addAtEnd("Maa", "Priyadarsan", 2023, 4.5f);
        mll.addAtEnd("GOAT", "S Shankar", 2000, 1.9f);

        mll.printList();
        System.out.println();

        mll.addAtPosition("Zara", "Khan", 2020, 5f,4 );
        mll.printList();
//        mll.removeMovie("ofn");
//
//        mll.printList();

        mll.searchByDirector("ghg");
        mll.searchByRating(5);

        mll.displayBackward();
    }
}
