package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            int maxB = 0;
            try(FileInputStream fileReader = new FileInputStream(fileName)) {
                while (fileReader.available() > 0) {
                    int curB = fileReader.read();
                    if (curB > maxB)
                        maxB = curB;
                }
            }
            System.out.println(maxB);
        }
    }

}
