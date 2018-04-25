package com.javarush.task.task25.task2512;

import java.util.ArrayList;
/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        Throwable element = e;
        while (element != null) {
            list.add(0,element);
            element = element.getCause();
        }
        for(Throwable throwable: list)
            System.out.println(throwable);

    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread("A"),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
