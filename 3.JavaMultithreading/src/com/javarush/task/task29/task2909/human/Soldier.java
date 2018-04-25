package com.javarush.task.task29.task2909.human;

/**
 * @author Ivanov
 * @since 25.04.2018.
 */
public class Soldier extends Human {
  public Soldier(String name, int age) {
    super(name, age);
  }

  public void fight() {
  }

  public void live() {
    fight();
  }
}
