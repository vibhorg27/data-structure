package com.bridgelabz.filereader;

import java.io.FileReader;

import java.io.*;

public class CountOccurrence {
    public static void main(String[] args) {
        String fileName = "src/com/bridgelabz/filereader/Sample.txt";
        String targetWord = "my";
        int wordCount = 0;

        try {

            FileReader fileReader = new FileReader(fileName);


            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;


            while ((line = bufferedReader.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equals(targetWord)) {
                        wordCount++;
                    }
                }
            }

            bufferedReader.close();

            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
        }
        catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

