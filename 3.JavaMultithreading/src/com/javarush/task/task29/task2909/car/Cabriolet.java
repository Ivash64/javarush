package com.javarush.task.task29.task2909.car;

/**
 * @author Ivanov
 * @since 25.04.2018.
 */
public class Cabriolet extends Car {
  public Cabriolet(int numberOfPassengers) {
    super(CABRIOLET,numberOfPassengers);
  }

  @Override
  public int getMaxSpeed() {
    return MAX_CABRIOLET_SPEED;
  }
}
