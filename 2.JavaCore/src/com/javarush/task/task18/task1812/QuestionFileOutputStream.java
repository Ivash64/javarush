package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
  AmigoOutputStream outputStream;

  public QuestionFileOutputStream(AmigoOutputStream outputStream) {
    this.outputStream = outputStream;
  }

  @Override
  public void flush() throws IOException {
    this.outputStream.flush();
  }

  @Override
  public void write(int b) throws IOException {
    this.outputStream.write(b);
  }

  @Override
  public void write(byte[] b) throws IOException {
    this.outputStream.write(b);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    this.outputStream.write(b,off,len);
  }

  @Override
  public void close() throws IOException {
    System.out.println("Вы действительно хотите закрыть поток? Д/Н");
    Scanner scanner = new Scanner(System.in);
    if ("Д".equals(scanner.next()))
      this.outputStream.close();
  }
}

