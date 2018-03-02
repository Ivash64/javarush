package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> wordList = detectAllWords(crossword, "prr", "home", "same");
        System.out.println(wordList);
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();
        for (String word: words){
            int [] chars = new int[word.toCharArray().length];
            for (int idx0 = 0; idx0 < word.toCharArray().length; idx0++)
                chars[idx0] = word.toCharArray()[idx0];

            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j <crossword[i].length; j++) {
                    if (crossword[i][j] == chars[0]) {
                        boolean found = false;
                        Word wordFound = new Word(word);
                        wordFound.setStartPoint(j,i);
                        if (chars.length > 1) {
                            for (int cntI = -1; cntI <= 1; cntI++) {
                                for (int cntJ = -1; cntJ <= 1; cntJ++) {
                                    if (cntI == 0 && cntJ == 0)
                                        continue;
                                    Direction dir = findWord(chars, new Direction(cntI,cntJ,i,j), crossword);
                                    if (dir != null) {
                                        wordFound.setEndPoint(dir.j,dir.i);
                                        wordList.add(wordFound);
                                    }
                                }
                            }
                        }else {
                            wordFound.setEndPoint(i,j);
                            wordList.add(wordFound);
                        }
                    }
                }
            }
        }

        return wordList;
    }

    private static Direction findWord(int[] chars, Direction dir, int[][] crossword) {
        int chrIdx = 1;
        while (chrIdx < chars.length ) {
            if (loopByChar(chars[chrIdx],crossword ,dir)){
                chrIdx ++;
                continue;
            }
            return null;
        }
        return dir;
    }

    private static boolean loopByChar(int curChar, int[][] crossword ,Direction dir) {
        if (checkChar(dir.i + dir.x, dir.j + dir.y, crossword, curChar)){
            dir.i = dir.i + dir.x;
            dir.j = dir.j + dir.y;
            return true;
        }
        return false;
    }

    private static boolean checkChar(int i, int j, int[][] crossword, int curChar){
        try {
            if (crossword[i][j] == curChar)
                return true;
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public static class Direction {
        public int x = -2, y = -2;
        public int i, j;

        public Direction(int x, int y, int i, int j) {
            this.x = x;
            this.y = y;
            this.i = i;
            this.j = j;
        }
    }
}
