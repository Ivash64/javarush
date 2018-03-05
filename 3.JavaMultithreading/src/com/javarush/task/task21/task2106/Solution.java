package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (!Objects.equals(solution1.aDouble, aDouble)) return false;
        if (anInt != solution1.anInt) return false;
        if (!Objects.equals(solution1.date, date)) return false;
        if (!Objects.equals(solution1.solution, solution)) return false;
        if (!Objects.equals(solution1.string, string)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Solution old = new Solution(0,null,0,null,null);
        System.out.println(old.equals(old));
        System.out.println(old.equals(null));

    }
}
