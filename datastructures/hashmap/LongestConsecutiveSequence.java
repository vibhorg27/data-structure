package com.bridgelabz.datastructures.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int getLongestConsecutiveSequence(int[] arr){
        int n = arr.length;
        if(n==0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // Add the elements to the set
        for (int i = 0; i < n ; i++) {
            set.add(arr[i]);
        }

        for(int it : set){
            // If previous number is not present
            if(!set.contains(it -1)){

                int count = 1;
                int x = it;
                while(set.contains(x + 1)){
                    x +=1;
                    count+=1;
                }
                longest = Math.max(longest, count);
            }

        }
        return longest;
    }

    public static void main(String[] args) {
        int[] array = {101, 4, 100, 5, 2, 1, 8, 3, 102};
        int ans = getLongestConsecutiveSequence(array);

        System.out.println(ans);
    }
}
