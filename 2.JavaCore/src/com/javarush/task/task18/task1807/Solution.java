package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            int cnt = 0;
            try (FileInputStream fileReader = new FileInputStream(fileName)) {
                while (fileReader.available() > 0)
                    if ((byte)',' == fileReader.read())
                        cnt++;

            }
            System.out.print(cnt);
        }
    }
}
