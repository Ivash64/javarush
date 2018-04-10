package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //C:\in.txt
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }
        ArrayList<String> words = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()) {
                words.addAll(Arrays.asList(fileReader.readLine().split("[ \r\n]")));
            }
        }
        StringBuilder result = getLine(words.toArray(new String[words.size()]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        Collections.sort(wordList);
        if (wordList.size() > 0) {
            String word1 = wordList.get(0);
            wordList.remove(0);
            boolean found = true;
            while (found) {
                found = false;
                String lastChar = word1.substring(word1.length() - 1, word1.length());
                for (int j = 0; j < wordList.size(); j++) {
                    String word2 = wordList.get(j);
                    if (word2.substring(0, 1).toUpperCase().equals(lastChar.toUpperCase())) {
                        found = true;
                        if (sb.length() == 0)
                            sb.append(word1);
                        sb.append(" ").append(word2);
                        wordList.remove(j);
                        word1 = word2;
                        break;
                    }
                }
            }
            for (String word : wordList)
                sb.append(" ").append(word);
        }
        return sb;
    }
}
