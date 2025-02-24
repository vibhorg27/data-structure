package com.bridgelabz.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineByLine {
    public static void main(String[] args) {
        String filename = "src/com/bridgelabz/filereader/Sample.txt";

        try{
            FileReader file = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(file);

            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

