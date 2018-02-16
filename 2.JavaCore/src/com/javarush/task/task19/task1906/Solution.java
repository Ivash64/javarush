package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileIn = reader.readLine();
            String fileOut = reader.readLine();
            try(FileReader fileReader = new FileReader(fileIn);
                FileWriter fileWriter = new FileWriter((fileOut))){
                int i = 0;
                while (fileReader.ready()){
                    int val = fileReader.read();
                    if (i == 1){
                        fileWriter.write(val);
                        i--;
                    }else
                        i++;
                }
            }
        }
    }
}
//D:\temp1.txt
//D:\temp2.txt