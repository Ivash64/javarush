package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    FileOutputStream os;
    public static String fileName = "C:/tmp/result.txt";
    public AmigoOutputStream(FileOutputStream os) throws FileNotFoundException {
        super(fileName);
        this.os = os;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.os.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        this.os.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.os.write(b);
    }

    @Override
    public void flush() throws IOException {
        this.os.flush();
    }

    @Override
    public void close() throws IOException {
        this.os.flush();
        this.os.write("JavaRush © All rights reserved.".getBytes());
        this.os.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
