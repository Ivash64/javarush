package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (String fileName = reader.readLine(); !"end".equals(fileName); fileName = reader.readLine())
                fileNames.add(fileName);
        }
        Collections.sort(fileNames);
        try(FileOutputStream os = new FileOutputStream(fileNames.get(0).replace(".part1",""))) {
            byte[] buffer;
            for(String file:fileNames){
                try(FileInputStream is = new FileInputStream(file)){
                    buffer = new byte[is.available()];
                    int count = is.read(buffer);
                    os.write(buffer, 0, count);
                }
            }
            os.flush();
        }
    }
}
