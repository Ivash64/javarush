package com.javarush.task.task15.task1522;

/**
 * @author Ivanov
 * @since 17.01.2018.
 */
public class Earth implements Planet {
  private static Earth instance = null;

  private Earth() {}

  public static Earth getInstance() {
    if (instance == null)
      instance = new Earth();
    return instance;
  }
}
