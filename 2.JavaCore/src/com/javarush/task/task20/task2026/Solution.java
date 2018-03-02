package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
            {1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {1, 1, 0, 1, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 5");
        int count4 = getRectangleCount(null);
        System.out.println("count = " + count4 + ". Должно быть 0");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == 1 && ((i == 0 && j == 0) ||
                        ((i == 0 || a[i - 1][j] == 0) && (j == 0 || a[i][j - 1] == 0))))
                        count++;

                }
            }
        } catch (Exception e){
            return 0;
        }

        return count;
    }
}
