package com.javarush.task.task14.task1417;

/**
 * @author Ivanov
 * @since 15.01.2018.
 */
public class Ruble extends Money {
  public Ruble(double amount) {
    super(amount);
  }

  @Override
  public String getCurrencyName() {
    return "RUB";
  }
}
