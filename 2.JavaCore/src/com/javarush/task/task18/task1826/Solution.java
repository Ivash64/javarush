package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(FileOutputStream os = new FileOutputStream(args[2])) {
            try(FileInputStream is = new FileInputStream(args[1])){
               while (is.available() > 0){
                   if ("-d".equals(args[0]))
                       os.write(is.read()+1);
                   if ("-e".equals(args[0]))
                       os.write(is.read()-1);
               }
            }
            os.flush();
        }
    }
}
