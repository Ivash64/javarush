package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try(FileInputStream is = new FileInputStream(scanner.next())){
                if (is.available() < 1000)
                    throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
