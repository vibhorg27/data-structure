package com.bridgelabz.datastructures.hashmap;

import java.util.HashMap;

public class FindPair {
    public static boolean twoSum(int[] arr, int target){
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int num = arr[i];
            int rem = target - arr[i];
            if(mpp.containsKey(rem)){
                return true;
            }
            mpp.put(arr[i] , i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 5, 8, 11};
        int target = 14;
        boolean ans = twoSum(array, target);
        System.out.println(ans);
    }
}
