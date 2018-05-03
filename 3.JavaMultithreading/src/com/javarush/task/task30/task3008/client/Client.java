package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/**
 * @author Ivanov
 * @since 03.05.2018.
 */
public class Client {
  protected Connection connection;
  private volatile boolean clientConnected = false;

  public static void main(String[] args) {
    Client client = new Client();
    client.run();
  }

  public void run() {
    SocketThread socketThread = getSocketThread();
    socketThread.setDaemon(true);
    socketThread.run();
    synchronized (Client.this) {
      try {
        wait();
      } catch (InterruptedException e) {
        ConsoleHelper.writeMessage(e.getMessage());
        return;
      }
    }
    if (clientConnected) {
      ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
      while (clientConnected) {
        String mes = ConsoleHelper.readString();
        if ("exit".equals(mes))
          break;
        if (shouldSendTextFromConsole())
          sendTextMessage(mes);
      }
    } else
      ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
  }

  protected String getServerAddress() {
    ConsoleHelper.writeMessage("Enter server address: ");
    return ConsoleHelper.readString();
  }

  protected int getServerPort() {
    ConsoleHelper.writeMessage("Enter server port: ");
    return ConsoleHelper.readInt();
  }

  protected String getUserName() {
    ConsoleHelper.writeMessage("Enter user name: ");
    return ConsoleHelper.readString();
  }

  protected boolean shouldSendTextFromConsole() {
    return true;
  }

  protected SocketThread getSocketThread() {
    return new SocketThread();
  }

  protected void sendTextMessage(String text) {

    try {
      connection.send(new Message(MessageType.TEXT, text));
    } catch (IOException e) {
      ConsoleHelper.writeMessage("error sending message");
      clientConnected = false;
    }
  }

  public static class SocketThread extends Thread {

  }
}
