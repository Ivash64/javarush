package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (FileReader reader = new FileReader(scanner.next())){
            try (BufferedReader bufferedReader = new BufferedReader(reader)){
                bufferedReader.lines().forEach(s -> {
                    String[] vals = s.split(" ");
                    if (Objects.equals(vals[0], args[0])){
                        System.out.println(s);
                    }
                });
            }
        }
    }
}