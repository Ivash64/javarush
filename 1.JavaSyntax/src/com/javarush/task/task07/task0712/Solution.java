package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        List<String> list = new ArrayList<>();
        Integer minLength = null, minIndex = null , maxLength = null , maxIndex = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for(int i = 0;i<10;i++) {
                list.add(reader.readLine());
                if (minIndex == null || minLength > list.get(i).length()){
                    minLength = list.get(i).length();
                    minIndex = i;
                }

                if (maxIndex == null || maxLength < list.get(i).length()){
                    maxLength = list.get(i).length();
                    maxIndex = i;
                }
            }
        }
        System.out.println(minIndex < maxIndex ? list.get(minIndex) : list.get(maxIndex));
    }
}
