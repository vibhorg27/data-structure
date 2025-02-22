package com.bridgelabz.runtimeanalysisandbigonotation;


import java.io.*;

public class LargeFileReadingEfficiency {

    public static void testFileReader(String filePath) {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.read() != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void testInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.read() != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        long endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        String filePath = "src/com/bridgelabz/runtimeanalysisandbigonotation/Sample.txt";
        testFileReader(filePath);
        testInputStreamReader(filePath);
    }
}

