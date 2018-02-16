package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream is = new FileInputStream(scanner.next());
        FileOutputStream os1 = new FileOutputStream(scanner.next());
        FileOutputStream os2 = new FileOutputStream(scanner.next());

        if (is.available() > 0) {
            int countHalf = is.available() % 2 != 0 ?
                is.available() / 2 + 1:
                (is.available() / 2);
            int cnt = 1;
            while (is.available() > 0) {
                if (cnt <= countHalf)
                    os1.write(is.read());
                else
                    os2.write(is.read());

                cnt++;
            }
        }
        os1.close();
        os2.close();
        is.close();
    }
}
