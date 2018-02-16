package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        Pattern p = Pattern.compile("\\b\\d+\\b");

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))){
            fileReader.lines().forEach(s -> {
                Matcher m = p.matcher(s);
                while (m.find())
                    try {
                        bufferedWriter.write(m.group()+" ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            });
        }
    }
}
