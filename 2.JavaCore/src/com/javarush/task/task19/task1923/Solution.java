package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("[.]*[\\d]+[.]*");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                while (reader.ready()){
                    String [] words = reader.readLine().split(" ");
                    for( String word: words){
                        if (p.matcher(word).find())
                            writer.write(word+" ");
                    }
                }
            }
        }
    }
}
