package com.bridgelabz.runtimeanalysisandbigonotation;


import java.util.*;

public class SearchComparison {

    public static boolean searchInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchInHashSet(HashSet<Integer> hashSet, int target) {
        return hashSet.contains(target);
    }

    public static boolean searchInTreeSet(TreeSet<Integer> treeSet, int target) {
        return treeSet.contains(target);
    }

    public static void main(String[] args) {
        int dataSize = 1_000_000;
        int[] array = new int[dataSize];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        Random random = new Random();
        for (int i = 0; i < dataSize; i++) {
            int value = random.nextInt(dataSize);
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }

        int target = array[random.nextInt(dataSize)];

        long startArray = System.nanoTime();
        boolean foundInArray = searchInArray(array, target);
        long endArray = System.nanoTime();
        System.out.println("Array Search Time: " + (endArray - startArray) / 1_000_000.0 + " ms");

        long startHashSet = System.nanoTime();
        boolean foundInHashSet = searchInHashSet(hashSet, target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) / 1_000_000.0 + " ms");

        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = searchInTreeSet(treeSet, target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) / 1_000_000.0 + " ms");
    }
}

