package com.javarush.task.task15.task1522;

/**
 * @author Ivanov
 * @since 17.01.2018.
 */
public class Sun implements Planet {
  private static Sun instance = null;

  private Sun() {}

  public static Sun getInstance() {
    if (instance == null)
      instance = new Sun();
    return instance;
  }
}
