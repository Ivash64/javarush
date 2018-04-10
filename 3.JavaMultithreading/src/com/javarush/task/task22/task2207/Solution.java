package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // C:\in.txt
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

        for (int i = 0; i < words.size(); i++) {
            String string = words.get(i);
            if (string.isEmpty()) continue;
            String reverseString = new StringBuilder(string).reverse().toString();
            for (int j = i + 1; j < words.size(); j++) {
                String string1 = words.get(j);
                if (string1.equals(reverseString)) {
                    result.add(new Pair(string, reverseString));
                    words.remove(i--);
                    words.remove(j - 1);
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
            super();
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                    second == null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
