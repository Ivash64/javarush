package com.javarush.task.task14.task1413;

/**
 * @author Ivanov
 * @since 15.01.2018.
 */
public class Mouse implements CompItem {
  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }
}
