package com.bridgelabz.filereader;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileWriter fileWriter = new FileWriter("src/com/bridgelabz/filereader/Sample.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            System.out.println("User input saved to Sample.txt");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
