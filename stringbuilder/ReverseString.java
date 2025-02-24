package com.bridgelabz.stringbuilder;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Strings: ");

        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());

        System.out.println("Reversed Strings: " + stringBuilder.reverse());

    }
}
