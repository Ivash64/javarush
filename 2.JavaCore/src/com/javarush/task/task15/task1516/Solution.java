package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;// = 0;
    public double doubleVar;// = 1d;
    public Double DoubleVar;// = 2d;
    public boolean booleanVar;// = true;
    public Object ObjectVar;// = 5;
    public Exception ExceptionVar;// = new Exception();
    public String StringVar;// = "aa";

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intVar);
        System.out.println(s.doubleVar);
        System.out.println(s.DoubleVar);
        System.out.println(s.booleanVar);
        System.out.println(s.ObjectVar);
        System.out.println(s.ExceptionVar);
        System.out.println(s.StringVar);
    }
}
