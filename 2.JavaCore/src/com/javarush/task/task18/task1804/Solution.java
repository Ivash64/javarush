package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            ArrayList<Byte> bytes = new ArrayList<>();
            try (FileInputStream fileReader = new FileInputStream(fileName)) {
                while (fileReader.available() > 0)
                    bytes.add((byte) fileReader.read());
            }
            int min = 0;
            if (bytes.size() > 0)
                min = Collections.frequency(bytes,bytes.get(0));
            TreeSet<Byte> result = new TreeSet<>() ;
            for(Byte curByte: bytes){
                int count = Collections.frequency(bytes,curByte);
                if (min == count)
                    result.add(curByte);
                if (min > count){
                    min = count;
                    result.clear();
                    result.add(curByte);
                }
            }
            for (Byte curByte: result){
                System.out.print(curByte+" ");
            }
        }
    }
}
