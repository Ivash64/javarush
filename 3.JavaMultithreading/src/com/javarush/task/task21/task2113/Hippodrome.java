package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivanov
 * @since 06.03.2018.
 */
public class Hippodrome {
  public static Hippodrome game;
  private List<Horse> horses;

  public Hippodrome(List<Horse> horses) {
    this.horses = horses;
  }

  public static void main(String[] args) throws InterruptedException {
    game = new Hippodrome(new ArrayList<>());
    game.getHorses().add(new Horse("Лош1", 3, 0));
    game.getHorses().add(new Horse("Лош2", 3, 0));
    game.getHorses().add(new Horse("Лош3", 3, 0));
    game.run();
    game.printWinner();
  }

  public List<Horse> getHorses() {
    return horses;
  }

  public void run() throws InterruptedException {
    for (int i = 0; i < 100 ; i++) {
      move();
      print();
      Thread.sleep(200);
    }

  }

  public void move() {
    for (Horse horse:
         horses) {
      horse.move();
    }

  }

  public void print() {
    for (Horse horse:
        horses) {
      horse.print();
      System.out.println("");
    }
    for (int i = 0; i < 10; i++) {
      System.out.println("");
    }
  }

  public Horse getWinner(){
    Horse maxDist = horses.get(0);
    for (Horse horse:
         horses) {
      if (horse.getDistance() > maxDist.getDistance())
        maxDist = horse;
    }
    return maxDist;
  }

  public void printWinner(){
    System.out.printf("Winner is %s!",getWinner().getName());
  }
}
