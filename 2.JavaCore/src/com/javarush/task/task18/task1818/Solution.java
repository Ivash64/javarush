package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileOutputStream os = new FileOutputStream(scanner.next());
        FileInputStream is1 = new FileInputStream(scanner.next());
        FileInputStream is2 = new FileInputStream(scanner.next());
        while (is1.available() > 0)
            os.write(is1.read());
        is1.close();
        while (is2.available() > 0)
            os.write(is2.read());
        is2.close();
        os.close();
    }
}
