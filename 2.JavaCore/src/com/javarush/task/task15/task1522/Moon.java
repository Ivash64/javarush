package com.javarush.task.task15.task1522;

/**
 * @author Ivanov
 * @since 17.01.2018.
 */
public class Moon implements Planet {
  private static Moon instance = null;

  private Moon() {}

  public static Moon getInstance() {
    if (instance == null)
      instance = new Moon();
    return instance;
  }
}