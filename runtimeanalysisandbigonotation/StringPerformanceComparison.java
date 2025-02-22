package com.bridgelabz.runtimeanalysisandbigonotation;


public class StringPerformanceComparison {

    public static void testStringConcatenation(int iterations) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "hello";
        }
        long endTime = System.nanoTime();
        System.out.println("Strings Concatenation Time: " + (endTime - startTime) + " ns");
    }

    public static void testStringBuilderConcatenation(int iterations) {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Concatenation Time: " + (endTime - startTime) + " ns");
    }

    public static void testStringBufferConcatenation(int iterations) {
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer Concatenation Time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        int iterations = 1000;
        testStringConcatenation(iterations);
        testStringBuilderConcatenation(iterations);
        testStringBufferConcatenation(iterations);
    }
}

