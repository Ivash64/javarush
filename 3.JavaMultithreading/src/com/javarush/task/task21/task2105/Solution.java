package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return Objects.equals(n.first,first) && Objects.equals(n.last,last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }

    @Override
    public int hashCode() {
        if (this.first == null && this.last == null) return 0;
        if (this.first == null) return 31 * (this.last.length());
        if (this.last == null) return 31 * (this.first.length());
        return 13 * (this.first.length() + this.last.length());
    }
}
