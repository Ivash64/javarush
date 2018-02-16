package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum1 = 0, sum2 = 0;
        int [] houses = new int[15];
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for(int i = 0; i<15 ;i++){
                houses[i] = Integer.valueOf(reader.readLine());
                if (i % 2 == 0)
                    sum1 += houses[i];
                else
                    sum2 += houses[i];
            }
        }
        if (sum1 > sum2 )
            System.out.println("В домах с четными номерами проживает больше жителей.");
        if (sum2 > sum1 )
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
