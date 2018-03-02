package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
  public static Map<Integer, String> map = new HashMap<Integer, String>();

  static {
    map.put(0, "ноль");
    map.put(1, "один");
    map.put(2, "два");
    map.put(3, "три");
    map.put(4, "четыре");
    map.put(5, "пять");
    map.put(6, "шесть");
    map.put(7, "семь");
    map.put(8, "восемь");
    map.put(9, "девять");
    map.put(10, "десять");
    map.put(11, "одиннадцать");
    map.put(12, "двенадцать");
  }

  public static void main(String[] args) throws IOException {
    String fileName = "";
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      fileName = reader.readLine();
    }
    //  ^     - (крышка, цирркумфлекс) начало проверяемой строки
    //$     - (доллар) конец проверяемой строки
    // () - группа  ( () integer  () )   = 3 группы. 1-ая внешние скобки

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      while (reader.ready()) {
        final String[] line = {reader.readLine()};
        map.forEach((integer, s) -> {
          Matcher m = Pattern.compile("((^| )" + integer + "( |$))").matcher(line[0]);
          while (m.find())
            line[0] = line[0].replaceAll(m.group(1), m.group(2) + s + m.group(3));
        });
        System.out.println(line[0]);
      }
    }
  }
}
