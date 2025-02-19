package com.bridgelabz.datastructures.linkedlist;


class BookNode {
    private String title;
    private String author;
    private String genre;
    private int id;
    private boolean isAvailable;

    public BookNode next;
    public BookNode prev;

    public BookNode(String title, String author, String genre, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}

class Library {
    private BookNode head;
    private BookNode tail;

    public void addAtStart(String title, String author, String genre, int id, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, id, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int id, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, id, isAvailable);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    public void availabilityStatus(String title) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode temp = head;
        while (temp != null) {
            if (temp.getTitle().equalsIgnoreCase(title)) {
                temp.setAvailable(!temp.isAvailable());
                System.out.println("Availability of '" + title + "' updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found: " + title);
    }

    public void searchByTitle(String title) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode temp = head;
        while (temp != null) {
            if (temp.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                System.out.println("Title: " + temp.getTitle());
                System.out.println("Author: " + temp.getAuthor());
                System.out.println("Genre: " + temp.getGenre());
                System.out.println("ID: " + temp.getId());
                System.out.println("Availability: " + (temp.isAvailable() ? "Available" : "Checked Out"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found: " + title);
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.getTitle());
            System.out.println("Author: " + temp.getAuthor());
            System.out.println("Genre: " + temp.getGenre());
            System.out.println("ID: " + temp.getId());
            System.out.println("Availability: " + (temp.isAvailable() ? "Available" : "Checked Out"));
            System.out.println();
            temp = temp.next;
        }
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.getTitle());
            System.out.println("Author: " + temp.getAuthor());
            System.out.println("Genre: " + temp.getGenre());
            System.out.println("ID: " + temp.getId());
            System.out.println("Availability: " + (temp.isAvailable() ? "Available" : "Checked Out"));
            System.out.println();
            temp = temp.prev;
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library collection = new Library();

        collection.addAtStart("The Alchemist", "Paulo Cohelo", "Philosophy", 101, true);
        collection.addAtEnd("Origin", "Dan Brown", "Fiction", 102, true);
        collection.addAtStart("Zero to One", "Peter Thiel", "Business", 103, true);
        collection.addAtStart("Mein Kamph", "Adolf Hitler", "AutoBiography", 104, true);

        collection.availabilityStatus("Origin");
        collection.searchByTitle("The Alchemist");

        System.out.println();
        collection.displayForward();
        System.out.println();
        collection.displayBackward();
    }
}