package com.bridgelabz.filereader;

import java.io.*;

public class ConvertByteToCharStream {
    public static void main(String[] args) {
        String fileName = "src/com/bridgelabz/filereader/binaryfile.txt";
        String charset = "UTF-8";

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

