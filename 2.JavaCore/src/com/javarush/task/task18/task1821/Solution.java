package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream is1 = new FileInputStream(args[0]);
        List<Integer> list = new ArrayList<>();

        while (is1.available() > 0)
            list.add(is1.read());
        is1.close();

        Collections.sort(list);
        Map<Integer,Integer> res = new TreeMap<>();
        for (Integer val: list)
            res.put(val,Collections.frequency(list,val));
        res.forEach((integer, integer2) -> System.out.println((char)integer.byteValue()+" "+integer2));
    }
}
