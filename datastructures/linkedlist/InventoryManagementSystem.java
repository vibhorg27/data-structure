package com.bridgelabz.datastructures.linkedlist;

import java.util.Scanner;

class ItemNode {
    private String itemName;
    private int itemID;
    private int quantity;
    private double price;
    public ItemNode next;

    public ItemNode(String itemName, int itemID, int quantity, double price){
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    public int getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ItemList{
    private ItemNode head;

    public void addAtStart(String itemName, int itemID, int quantity, double price){
        ItemNode newItemNode = new ItemNode(itemName, itemID, quantity, price);
        newItemNode.next = head;
        head = newItemNode;
    }

    public void addAtEnd(String itemName, int itemID, int quantity, double price){
        ItemNode newItemNode = new ItemNode(itemName, itemID, quantity, price);
        if(head == null){
            head = newItemNode;
            return;
        }
        ItemNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newItemNode;
    }

    public void addAtIndex(String itemName, int itemID, int quantity, double price, int index){
        if(index == 0){
            addAtStart(itemName,itemID, quantity, price);
        }
        ItemNode newItemNode = new ItemNode(itemName, itemID, quantity, price);
        ItemNode temp = head;
        while(temp != null && index > 1){
            temp = temp.next;
            index--;
        }
        if(temp == null){
            System.out.println("Index out of bounds.");
            return;
        }
        newItemNode.next = temp.next;
        temp.next = newItemNode;
    }

    public void removeItemWithItemID(int itemID){

        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }
        // To remove item at head
        if(head.getItemID() == itemID){
            head = head.next;
            return;
        }

        ItemNode temp = head;
        ItemNode prev = null;
        while(temp != null && temp.getItemID() != itemID){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Item not found");
            return;
        }
        if (prev != null) {
            prev.next = temp.next;
            return;
        }
    }

    public void updateQuantity(int itemID){

        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        ItemNode temp = head;
        while (temp != null && temp.getItemID() != itemID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("ItemNode with ID " + itemID + " not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new quantity for item: ");
        int newQuantity = scanner.nextInt();
        temp.setQuantity(newQuantity);

        System.out.println("Quantity updated successfully.");
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.getQuantity() * temp.getPrice();
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: Rs." + totalValue);
    }

    public void sortByPrice(){
        if(head == null || head.next == null) return;

        for(ItemNode i = head; i != null; i = i.next){
            for(ItemNode j = head; j != null; j = j.next){
                if(j.getPrice() > j.next.getPrice()){
                    swap(j,j.next);
                }
            }
        }
    }

    private void swap(ItemNode a, ItemNode b) {
        String tempName = a.getItemName();
        int tempID = a.getItemID();
        int tempQuantity = a.getQuantity();
        double tempPrice = a.getPrice();

        a.setItemName(b.getItemName());
        a.setItemID(b.getItemID());
        a.setQuantity(b.getQuantity());
        a.setPrice(b.getPrice());

        b.setItemName(tempName);
        b.setItemID(tempID);
        b.setQuantity(tempQuantity);
        b.setPrice(tempPrice);
    }

    public void displayList(){
        if(head == null){
            return;
        }
        ItemNode temp = head;
        while(temp != null){
            System.out.println("ItemNode Name: " + temp.getItemName());
            System.out.println("ItemNode ID: " + temp.getItemID());
            System.out.println("Quantity: " + temp.getQuantity());
            System.out.println("Price: " + temp.getPrice());
            System.out.println();
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        ItemList movieList = new ItemList();

        movieList.addAtStart("Book", 101, 2, 100);
        movieList.addAtEnd("Toothbrush", 102, 1, 40);
        movieList.addAtStart("Milk", 105, 5, 30);
        movieList.addAtStart("Cheese", 106, 4, 50);

        movieList.addAtIndex("Biscuits", 102, 7, 150,4);

        movieList.displayList();
    }
}