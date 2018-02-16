package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> listInt = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for(int i = 0;i<10;i++)
                listInt.add(Integer.valueOf(reader.readLine()));
        }
        int max = 0;
        int count = 0;
        Integer prevCur = listInt.get(0);
        for (Integer cur: listInt){
            if (Objects.equals(prevCur, cur)){
                count++;
            }else {
                count = 1;
                prevCur = cur;
            }
            if (count > max)
                max = count;
        }
        System.out.println(max);
    }
}