package com.bridgelabz.datastructures.linkedlist;

class TextNode {
    String text;
    TextNode prev, next;

    public TextNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditorList {
    private TextNode head;
    private TextNode current;
    private final int limit;
    private int size;

    public TextEditorList(int limit) {
        this.limit = limit;
        this.size = 0;
        this.head = null;
        this.current = null;
    }

    public void addState(String text) {
        TextNode newNode = new TextNode(text);
        if (current == null) {
            head = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        size++;

        if (size > limit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayState() {
        if (current == null) {
            System.out.println("No content");
            return;
        }
        System.out.println(current.text);
    }
}

public class TextEditor{
    public static void main(String[] args) {
        TextEditorList editor = new TextEditorList(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayState();

        editor.undo();
        editor.displayState();

        editor.undo();
        editor.displayState();

        editor.redo();
        editor.displayState();
    }
}
