package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String fileName1 = "", fileName2 = "";
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                fileName1 = reader.readLine();
                fileName2 = reader.readLine();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
                allLines.addAll(reader.lines().collect(Collectors.toList()));
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName2))) {
                forRemoveLines.addAll(reader.lines().collect(Collectors.toList()));
            }
            new Solution().joinData();
        }catch (Exception e) {};
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
