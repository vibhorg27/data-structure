package com.bridgelabz.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

class UserNode {
    int id;
    String name;
    int age;
    List<Integer> friends;
    UserNode next;

    public UserNode(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class UserLinkedList {
    private UserNode head;

    public void addUser(int id, String name, int age) {
        UserNode newUserNode = new UserNode(id, name, age);
        if (head == null) {
            head = newUserNode;
            return;
        }
        UserNode temp = head;
        while (temp.next != null) {
            if (temp.id == id) {
                System.out.println("User with ID " + id + " already exists.");
                return;
            }
            temp = temp.next;
        }
        temp.next = newUserNode;
    }

    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friends.contains(userId2)) user1.friends.add(userId2);
        if (!user2.friends.contains(userId1)) user2.friends.add(userId1);
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friends.remove(Integer.valueOf(userId2));
        user2.friends.remove(Integer.valueOf(userId1));
    }

    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print(user.name + "'s friends: ");
        for (int friendId : user.friends) {
            UserNode friend = findUserById(friendId);
            if (friend != null) System.out.print(friend.name + " ");
        }
        System.out.println();
    }

    public void displayUsers() {
        if (head == null) {
            System.out.println("No users found.");
            return;
        }
        UserNode temp = head;
        while (temp != null) {
            System.out.println("User: " + temp.name + " (ID: " + temp.id + ", Age: " + temp.age + ")");
            temp = temp.next;
        }
    }

    private UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaConnections {
    public static void main(String[] args) {
        UserLinkedList userList = new UserLinkedList();
        userList.addUser(1, "Aryan", 25);
        userList.addUser(2, "Sheryas", 27);
        userList.addUser(3, "Vibhor", 22);
        userList.addUser(4, "Leon", 30);

        userList.addFriend(1, 2);
        userList.addFriend(1, 3);
        userList.addFriend(2, 4);

        userList.displayFriends(1);
        userList.displayFriends(2);

        userList.removeFriend(1, 3);
        userList.displayFriends(1);

        userList.displayUsers();
    }
}
