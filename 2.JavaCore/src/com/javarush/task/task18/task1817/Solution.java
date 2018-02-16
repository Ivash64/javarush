package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        float cntSpace = 0, cntOther = 0;
        FileInputStream fis = new FileInputStream(args[0]);
        cntOther = fis.available();
        while (fis.available() > 0){
            if ((byte)' ' == fis.read())
                cntSpace++;
        }
        System.out.println(String.format("%.2f",cntSpace/cntOther * 100));
        fis.close();
    }
}
