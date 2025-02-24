package com.bridgelabz.stringbuilder;

import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicateCharacters(String s){
        StringBuilder result = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                result.append(c);
            }
        }
        return  result.toString();
    }

    public static void main(String[] args) {
        String input = "Heeloonrg";
        System.out.println(removeDuplicateCharacters(input));

    }
}
