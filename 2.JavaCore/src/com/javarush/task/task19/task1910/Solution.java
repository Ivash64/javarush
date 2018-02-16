package com.javarush.task.task19.task1910;

/*
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))){
            fileReader.lines().forEach(s -> {
                try{
                    bufferedWriter.write(s.replaceAll("\\p{Punct}",""));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
