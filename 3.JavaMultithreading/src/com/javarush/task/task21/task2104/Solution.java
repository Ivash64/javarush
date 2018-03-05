package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
  private final String first, last;

  public Solution(String first, String last) {
    this.first = first;
    this.last = last;
  }

  public static void main(String[] args) {
    Set<Solution> s = new HashSet<>();
    s.add(new Solution("Donald", "Duck"));
    System.out.println(s.contains(new Solution("Donald", "Duck")));
  }

  @Override
  public boolean equals(Object n) {
    if (this == n) return true;

    if (n == null || !(n instanceof Solution)) return false;

    Solution tmp = (Solution) n;

    return Objects.equals(this.first, tmp.first) && Objects.equals(this.last, tmp.last) ;
  }

  @Override
  public int hashCode() {
    if (this.first == null && this.last == null) return 0;
    if (this.first == null) return 31 * (this.last.length());
    if (this.last == null) return 31 * (this.first.length());
    return 13 * (this.first.length() + this.last.length());
  }
}
