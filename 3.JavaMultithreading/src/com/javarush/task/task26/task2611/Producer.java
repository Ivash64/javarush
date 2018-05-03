package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ivanov
 * @since 26.04.2018.
 */
public class Producer implements Runnable {
  private ConcurrentHashMap<String, String> map;

  public Producer(ConcurrentHashMap<String, String> map) {
    this.map = map;
  }

  @Override
  public void run() {
    try {
      AtomicInteger i = new AtomicInteger(1);
      while (true) {
        map.put(String.valueOf(i.get()), "Some text for "+i.get());
        i.incrementAndGet();
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
    }
  }
}
