package com.javarush.task.task29.task2909.car;

/**
 * @author Ivanov
 * @since 25.04.2018.
 */
public class Sedan extends Car {
  public Sedan(int numberOfPassengers) {
    super(SEDAN,numberOfPassengers);
  }

  @Override
  public int getMaxSpeed() {
    return MAX_SEDAN_SPEED;
  }
}
