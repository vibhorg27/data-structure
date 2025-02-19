package com.bridgelabz.datastructures.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class SubarraySum {
    public static List<List<Integer>> SubarrayWithZeroSum(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;

        // Add a base case: sum 0 at index -1 (before array starts)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum has been seen before, get all start indices
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(Arrays.asList(start + 1, i)); // Store (start+1) to i
                }
            }

            // Store current sum with its index
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<List<Integer>> result = SubarrayWithZeroSum(nums);

        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}
