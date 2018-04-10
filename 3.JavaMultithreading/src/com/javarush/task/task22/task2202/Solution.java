package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучшийсервисобученияJava."));
    }

    public static String getPartOfString(String string) {
        try {
            int pos1 = chekPos(string.indexOf(" "));
            int pos2 = chekPos(string.indexOf(" ", pos1 + 1));
            int pos3 = chekPos(string.indexOf(" ", pos2 + 1));
            int pos4 = chekPos(string.indexOf(" ", pos3 + 1));
            int pos5 = string.indexOf(" ", pos4 + 1);
            if (pos5 > 0)
                return string.substring(pos1 + 1, pos5);
            else
                return string.substring(pos1 + 1);
        }catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }

    private static int chekPos(int pos){
        if (pos < 0)
            throw new TooShortStringException();
        return pos;
    }
}
