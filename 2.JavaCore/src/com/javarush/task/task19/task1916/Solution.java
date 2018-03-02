package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        /*C:\in.txt
C:\out.txt*/
        String file1 = "", file2 = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
        }
        ArrayList<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file1))){
            while (reader.ready()) list1.add(reader.readLine());
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file2))){
            while (reader.ready()) list2.add(reader.readLine());
        }
        boolean size = list1.size() > list2.size();
        int max = size ? list1.size() : list2.size();


        for (int i = 0; i < max; i++ ) {
            try {
                if (list1.get(i).equals(list2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    list2.remove(0);
                } else if (list1.get(i).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                    i--;
                } else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                }
            } catch (IndexOutOfBoundsException e) {
                if (size) lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                else  lines.add(new LineItem(Type.ADDED, list2.get(0)));
                break;
            }
        }
        if (list1.size() == 1)
            lines.add(new LineItem(Type.REMOVED, list1.get(0)));
        if (list2.size() == 1)
            lines.add(new LineItem(Type.ADDED, list2.get(0)));

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
