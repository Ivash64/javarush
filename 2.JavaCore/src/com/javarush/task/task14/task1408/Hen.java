package com.javarush.task.task14.task1408;

/**
 * @author Ivanov
 * @since 09.01.2018.
 */
public abstract class Hen {
  abstract int getCountOfEggsPerMonth();

  String getDescription(){
    return "Я - курица.";
  }
}
