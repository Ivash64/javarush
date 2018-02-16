package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        FileInputStream fis = new FileInputStream(args[0]);
        while (fis.available() > 0){
            int val = fis.read();
            if ((val >= 65 && val <= 90) || (val >= 97 && val <=122))
                cnt++;
        }
        System.out.println(cnt);
        fis.close();
    }
}
