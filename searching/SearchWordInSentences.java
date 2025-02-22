package com.bridgelabz.searching;


public class SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String target) {
        for (String sentence : sentences) {
            if (sentence.contains(target)) return sentence;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"Hello world", "Java programming", "Search algorithms"};
        String target = "Java";
        System.out.println(findSentenceWithWord(sentences, target));
    }
}

