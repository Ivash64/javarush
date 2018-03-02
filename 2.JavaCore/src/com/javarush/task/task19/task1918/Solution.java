package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
  private static TreeMap<Integer, String> sortTags = new TreeMap<>();

  public static void main(String[] args) throws IOException {
    //C:\in.txt
    String fileName = "";
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      fileName = reader.readLine();
    }
    StringBuilder file = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      while (reader.ready()) {
        file.append(reader.readLine());
      }
    }

    //a?   =  a один раз или ни разу
    //[^abc] =  символ, исключая a, b и c
    //a* = a ноль или более раз
    Pattern pattern = Pattern.compile("</?" + args[0] + "[^>]*>");
    Matcher match = pattern.matcher(file.toString());
    Stack<Integer> otkrstack = new Stack<>();
    int i, n;
    while (match.find()) { //находим тег
      n = match.start();
      i = match.end();
      char sim = file.toString().charAt(n + 1);
      //если это не закрывающий тег, то добавлем в стек
      if (!Character.toString(sim).equals("/"))
        otkrstack.push(n);
      else {
        //иначе забираем послежний тег из стека и добавляем в дерево
        int beg = otkrstack.pop();
        sortTags.put(beg, file.toString().substring(beg, i));
      }
    }
    for (String tagS: sortTags.values())
      System.out.println(tagS);
  }
}
