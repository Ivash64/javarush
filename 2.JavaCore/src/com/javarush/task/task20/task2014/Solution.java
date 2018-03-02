package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println(new Solution(4));

        File your_file_name = File.createTempFile("your_file_name", null);
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);

        Solution savedObject = new Solution(4);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();

        outputStream.close();

        Solution loadedObject = new Solution(5);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        loadedObject = (Solution) objectInputStream.readObject();

        objectInputStream.close();
        inputStream.close();

        System.out.println(loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
