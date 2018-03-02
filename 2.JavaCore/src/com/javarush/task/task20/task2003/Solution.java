package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine())){
            load(fileInputStream);
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propWrire = new Properties();
        properties.forEach(propWrire::put);
        propWrire.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propRead = new Properties();
        propRead.load(inputStream);
        propRead.forEach((o, o2) -> properties.put((String)o,(String)o2));
    }

    public static void main(String[] args) {

    }
}
