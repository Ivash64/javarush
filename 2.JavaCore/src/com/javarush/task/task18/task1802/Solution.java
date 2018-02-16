package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            int minB = 0;
            try(FileInputStream fileReader = new FileInputStream(fileName)) {
                if (fileReader.available() > 0)
                    minB = fileReader.read();
                while (fileReader.available() > 0) {
                    int curB = fileReader.read();
                    if (curB < minB)
                        minB = curB;
                }
            }
            System.out.println(minB);
        }
    }
}
