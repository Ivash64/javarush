package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int pos1 = chekPos(string.indexOf("\t"));
            int pos2 = chekPos(string.indexOf("\t", pos1 + 1));
            return string.substring(pos1 + 1, pos2);
        }catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    private static int chekPos(int pos) throws TooShortStringException {
        if (pos < 0)
            throw new TooShortStringException();
        return pos;
    }
}
