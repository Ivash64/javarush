package com.javarush.task.task15.task1530;

/**
 * @author Ivanov
 * @since 19.01.2018.
 */
public abstract class DrinkMaker {
  abstract void getRightCup();
  abstract void putIngredient();
  abstract void pour();

  void makeDrink(){
    getRightCup();
    putIngredient();
    pour();
  }
}
