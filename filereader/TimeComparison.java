package com.bridgelabz.filereader;
import java.io.*;

public class TimeComparison {
    public static void main(String[] args) {
        compareStringConcatenation();
        countWordsInFile("src/com/bridgelabz/filereader/Sample.txt");
    }

    public static void compareStringConcatenation() {
        String text = "hello";

        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            stringBuilder.append(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) {
            stringBuffer.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + "ms");
    }

    public static void countWordsInFile(String filePath) {
        try (
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))
        ) {
            String line;
            int wordCount = 0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Total word count in file: " + wordCount);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());;
        }
    }
}
