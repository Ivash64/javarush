package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!"exit".equals(line)){
            try{
                if(line.contains("."))
                    print(Double.valueOf(line));
                else {
                    Integer intValue = Integer.valueOf(line);
                    if (intValue > 0 && intValue < 128) {
                        print(Short.valueOf(line));
                    }else
                        print(intValue);
                }

            }catch (Exception e){
                print(line);
            }
            line = reader.readLine();
        }
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
