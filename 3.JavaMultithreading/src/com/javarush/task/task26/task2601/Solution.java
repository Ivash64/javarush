package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
       Integer[] array =  sort(new Integer[]{13, 8, 15, 5, 17});

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        final int median = list.size() % 2 == 0 ? (list.get(list.size()/2 - 1) + list.get(list.size()/2))/2 :
            list.get(list.size()/2);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> Math.abs(median - o));
        list.sort(comparator);
        return array;
    }
}
