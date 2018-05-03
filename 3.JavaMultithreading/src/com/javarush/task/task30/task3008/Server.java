package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ivanov
 * @since 27.04.2018.
 */
public class Server {
  private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

  public static void main(String[] args) {
    try {
      System.out.print("Укажите порт сервера: ");
      int port = ConsoleHelper.readInt();
      try (ServerSocket socket = new ServerSocket(port)) {
        System.out.println("Сервер запущен");
        while (true) {
          Socket socketAccept = socket.accept();
          Handler handler = new Handler(socketAccept);
          handler.start();
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void sendBroadcastMessage(Message message) {
    for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
      try {
        entry.getValue().send(message);
      } catch (Exception e) {
        System.out.println("Ошибка отправки сообщения");
      }
    }
  }


  private static class Handler extends Thread {
    private final Socket socket;

    public Handler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      String userName = null;
      ConsoleHelper.writeMessage("установлено соединение с удаленным адресом"+socket.getRemoteSocketAddress());
      try (Connection connection = new Connection(socket)) {
        userName = serverHandshake(connection);
        sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
        sendListOfUsers(connection, userName);
        serverMainLoop(connection, userName);

      } catch (IOException | ClassNotFoundException e) {
        ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
      }
      if (userName != null) {
        connectionMap.remove(userName);
        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
      }
      ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
    }

    private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
      while (true) {
        connection.send(new Message(MessageType.NAME_REQUEST));
        Message ansName = connection.receive();
        if (MessageType.USER_NAME == ansName.getType() && !ansName.getData().isEmpty() && connectionMap.get(ansName.getData()) == null) {
          String name = ansName.getData();
          connectionMap.put(name, connection);
          connection.send(new Message(MessageType.NAME_ACCEPTED));
          return name;
        }
      }
    }

    private void sendListOfUsers(Connection connection, String userName) throws IOException {
      for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
        if (!entry.getKey().equals(userName))
          connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
      }
    }

    private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
      while (true) {
        Message message = connection.receive();
        if (message.getType() == MessageType.TEXT) {
          String text = userName + ": " + message.getData();
          sendBroadcastMessage(new Message(MessageType.TEXT, text));
        } else
          ConsoleHelper.writeMessage("Сообщение не является TEXT");
      }
    }
  }
}
