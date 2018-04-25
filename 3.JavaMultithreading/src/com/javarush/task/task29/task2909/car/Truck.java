package com.javarush.task.task29.task2909.car;

/**
 * @author Ivanov
 * @since 25.04.2018.
 */
public class Truck extends Car {
  public Truck(int numberOfPassengers) {
    super(TRUCK,numberOfPassengers);
  }

  @Override
  public int getMaxSpeed() {
    return MAX_TRUCK_SPEED;
  }
}
