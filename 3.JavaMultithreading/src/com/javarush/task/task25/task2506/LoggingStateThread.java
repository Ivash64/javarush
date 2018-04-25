package com.javarush.task.task25.task2506;

/**
 * @author Ivanov
 * @since 19.04.2018.
 */
public class LoggingStateThread extends Thread{
  Thread target;

  public LoggingStateThread(Thread target1) {
    this.target = target1;
  }

  @Override
  public void run() {
    String stateTarget = target.getState().name();
    System.out.println(stateTarget);
    while (true) {
      if (!(stateTarget.equals(target.getState().name()))) {
        stateTarget = target.getState().name();
        System.out.println(stateTarget);
        if (stateTarget.equals("TERMINATED")) {
          break;
        }
      }
    }
  }
}
