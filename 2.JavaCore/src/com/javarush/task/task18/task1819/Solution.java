package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.next(), file2 = scanner.next();

        FileInputStream is1 = new FileInputStream(file1);
        byte[] bytes = new byte[is1.available()];
        is1.read(bytes);
        is1.close();

        FileOutputStream os = new FileOutputStream(file1);
        is1 = new FileInputStream(file2);
        while (is1.available() > 0)
            os.write(is1.read());
        os.write(bytes);
        is1.close();
        os.close();
    }
}
