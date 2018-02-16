package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);

        String result = outputStream.toString();
        int typeOP = -1;
        int posOp = -1;
        if (result.indexOf("+") > 0) {
            posOp = result.indexOf("+");
            typeOP = 0;
        }
        if (result.indexOf("-") > 0) {
            posOp = result.indexOf("-");
            typeOP = 1;
        }

        if (result.indexOf("*") > 0) {
            posOp = result.indexOf("*");
            typeOP = 2;
        }
        if (posOp > 0){
            int aValue = Integer.parseInt(result.substring(0,posOp).trim());
            int bValue = Integer.parseInt(result.substring(posOp+1,result.indexOf("=")).trim());
            switch (typeOP){
                case 0: aValue += bValue; break;
                case 1: aValue -= bValue; break;
                case 2: aValue *= bValue; break;
            }
            result = result.concat(String.valueOf(aValue));
        }

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

