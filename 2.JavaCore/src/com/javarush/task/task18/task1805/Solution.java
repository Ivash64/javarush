package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            TreeSet<Byte> result = new TreeSet<>() ;
            try (FileInputStream fileReader = new FileInputStream(fileName)) {
                while (fileReader.available() > 0)
                    result.add((byte) fileReader.read());
            }
            for (Byte curByte: result){
                System.out.print(curByte+" ");
            }
        }
    }
}
