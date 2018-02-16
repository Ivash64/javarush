package com.javarush.task.task14.task1410;

/**
 * @author Ivanov
 * @since 10.01.2018.
 */
public abstract class Drink {
  public void taste(){
    System.out.println("Вкусно");
  }
  public abstract String getHolidayName();
}
