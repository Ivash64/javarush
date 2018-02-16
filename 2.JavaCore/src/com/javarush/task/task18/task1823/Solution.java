package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String fileName = reader.readLine(); !fileName.equals("exit"); fileName = reader.readLine()){
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            readThread.join();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            super();
            this.fileName = fileName;
        }
        @Override
        public void run() {
            try {
                FileInputStream is1 = new FileInputStream(fileName);
                List<Integer> list = new ArrayList<>();
                while (is1.available() > 0)
                    list.add(is1.read());
                is1.close();

                int cntMax = 0;
                int byteMax = 0;
                for(int curByte: list){
                    if (cntMax < Collections.frequency(list,curByte)){
                        cntMax = Collections.frequency(list,curByte);
                        byteMax = curByte;
                    }
                }
                resultMap.put(fileName,byteMax);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
