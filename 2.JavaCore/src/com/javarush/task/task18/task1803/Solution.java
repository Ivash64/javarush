package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/* 
Самые частые байты
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
            int max = 0;
            TreeSet<Byte> result = new TreeSet<>() ;
            for(Byte curByte: bytes){
                int count = Collections.frequency(bytes,curByte);
                if (max == count)
                    result.add(curByte);
                if (max < count){
                    max = count;
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
