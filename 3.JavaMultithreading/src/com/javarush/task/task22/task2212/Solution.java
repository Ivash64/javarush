package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() == 0) return false;
        Pattern pDigit = Pattern.compile("\\d");
        Matcher m = pDigit.matcher(telNumber);
        int cntDigit = 0;
        while (m.find())
         cntDigit++;
        if ("+".equals(telNumber.substring(0,1)) && cntDigit != 12)
            return false;
        if (telNumber.substring(0,1).matches("(\\(|\\d)") && cntDigit != 10)
            return false;

        return telNumber.matches("^(\\d|\\+)(\\d*)(\\(\\d{3}\\))?(\\d+-){0,2}\\d+");
    }

    public static void main(String[] args) {
        String[] s = {
            "",
            "+380501234567",
            "+38(050)1234567",
            "+38050123-45-67",
            "050123-4567",
            "+38)050(1234567",
            "+38(050)1-23-45-6-7",
            "+38(050)1-23-4567",
            "+38(050)1-234567",
            "050ххх4567",
            "0501236",
            "(0)501234567",
            "+38(050)1-23-45--6-7",
            "+3-8(050)1-23-45--6-7",
            "+38050123-4567-"
        };

        for (String t : s) System.out.printf("%s :   %s %n",t,checkTelNumber(t));
    }
}
