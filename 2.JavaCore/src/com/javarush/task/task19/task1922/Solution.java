package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                int count = 0;
                String  value = reader.readLine();
                String[] wordsInLine = value.split(" ");
                for (String word: words)
                    for(String wordInLine: wordsInLine)
                        if (word.toUpperCase().equals(wordInLine.toUpperCase()))
                            count++;

                if (count == 2)
                    System.out.println(value);
            }
        }
    }
}
