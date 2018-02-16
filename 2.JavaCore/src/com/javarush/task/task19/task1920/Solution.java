package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String[]  values = reader.readLine().split(" ");
                treeMap.merge(values[0],Double.parseDouble(values[1]),Double::sum);
            }
        }
        double amount = Collections.max(treeMap.values());
        Set<String> set = new TreeSet<>();
        treeMap.forEach((s, aDouble) -> {
            if (aDouble >= amount)
                set.add(s);
        });
        set.forEach(System.out::println);
    }
}
