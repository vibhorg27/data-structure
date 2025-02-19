package com.bridgelabz.datastructures.hashmap;

import java.util.*;

class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap<K, V> {
    private int capacity;
    private int size;
    private LinkedList<HashNode<K, V>>[] buckets;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<HashNode<K, V>> bucket = buckets[index];

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update existing key
                return;
            }
        }

        bucket.add(new HashNode<>(key, value)); // Insert new key
        size++;
    }

    public V get(K key) {
        int index = hashFunction(key);
        LinkedList<HashNode<K, V>> bucket = buckets[index];

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int index = hashFunction(key);
        LinkedList<HashNode<K, V>> bucket = buckets[index];

        Iterator<HashNode<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            HashNode<K, V> node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            for (HashNode<K, V> node : buckets[i]) {
                System.out.print("[" + node.key + " -> " + node.value + "] ");
            }
            System.out.println();
        }
    }
}

public class HashMapImplementation {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(5);

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("A", 10); // Updating

        map.display();

        System.out.println("Get 'C': " + map.get("C"));
        System.out.println("Get 'X': " + map.get("X"));

        map.remove("B");
        System.out.println("After removing 'B':");
        map.display();
    }
}

