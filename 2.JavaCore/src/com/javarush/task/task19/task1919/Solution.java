package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String[]  values = reader.readLine().split(" ");
                treeMap.merge(values[0],Double.parseDouble(values[1]),Double::sum);
            }
        }
        treeMap.forEach((s, aDouble) -> System.out.println(s+" "+aDouble));
    }
}
