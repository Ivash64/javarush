package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integerList = new ArrayList<>();
        int value = Integer.valueOf(reader.readLine());
        while (value != -1){
            integerList.add(value);
            value = Integer.valueOf(reader.readLine());
        }
        double sum = 0;
        for(Integer curVal: integerList){
            sum += curVal;
        }
        System.out.println(sum/integerList.size());
    }
}

