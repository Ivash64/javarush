package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        boolean isFirst = true;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                while (reader.ready()){
                    String [] words = reader.readLine().split(" ");
                    for( String word: words){
                        if (word.length() > 6) {
                            writer.write(isFirst ?
                                word :
                                ","+word);
                            isFirst = false;
                        }
                    }
                }
            }
        }

    }
}
