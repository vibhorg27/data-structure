package com.bridgelabz.stringbuffer;

public class ConcatenateStrings {
    public static String getConcatenatedStrings(String[] input){
        StringBuffer stringBuffer = new StringBuffer();

        for(String s : input){
            stringBuffer.append(s);
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String[] s = {"hello ", "world ", "of ", "wonderland"};
        System.out.println(getConcatenatedStrings(s));
    }
}
