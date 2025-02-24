package com.bridgelabz.stringbuffer;

public class CompareTime {
    public static final int ITERATIONS = 1_000_000; // 1 million iterations

    public static void main(String[] args) {
        comparePerformance();
    }

    public static void comparePerformance() {
        // Measure StringBuilder Performance
        StringBuilder stringBuilder = new StringBuilder();
        long startTime = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            stringBuilder.append("hello");
        }

        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1_000_000 + " ms");

        // Measure StringBuffer Performance
        StringBuffer stringBuffer = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuffer.append("hello");
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1_000_000 + " ms");

        // Compare and Print the Faster Approach
        if (stringBuilderTime < stringBufferTime) {
            System.out.println("StringBuilder is faster by " + (stringBufferTime - stringBuilderTime) / 1_000_000 + " ms");
        } else {
            System.out.println("StringBuffer is faster by " + (stringBuilderTime - stringBufferTime) / 1_000_000 + " ms");
        }
    }
}

