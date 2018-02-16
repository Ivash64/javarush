package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream is = new FileInputStream(scanner.next());
        FileOutputStream os1 = new FileOutputStream(scanner.next());
        List<Integer> bytes = new ArrayList<>();
        while (is.available() > 0)
            bytes.add(is.read());
        Collections.reverse(bytes);
        for(Integer val: bytes)
            os1.write(val);
        os1.close();
        is.close();
    }
}
