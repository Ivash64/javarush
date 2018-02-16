package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface{
      ATableInterface src;

      public TableInterfaceWrapper(ATableInterface src) {
        this.src = src;
      }

      @Override
      public void setModel(List rows) {
        System.out.println(rows.size());
        src.setModel(rows);
      }

      @Override
      public String getHeaderText() {
        return src.getHeaderText().toUpperCase();
      }

      @Override
      public void setHeaderText(String newHeaderText) {
        src.setHeaderText(newHeaderText);
      }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}