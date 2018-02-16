package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (FileReader reader = new FileReader(scanner.next())){
            try (BufferedReader bufferedReader = new BufferedReader(reader)){
                try(FileOutputStream os = new FileOutputStream(scanner.next())) {
                    String[] vals = bufferedReader.readLine().split(" ");
                    for (String val : vals) {
                        os.write(((Long) Math.round(Double.parseDouble(val))).toString().getBytes());
                        os.write(" ".getBytes());
                    }
                }
            }
        }
    }
}
