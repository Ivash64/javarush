package com.javarush.task.task30.task3008;

/**
 * @author Ivanov
 * @since 27.04.2018.
 */
public enum MessageType {
  NAME_REQUEST, //запрос имени
  USER_NAME, //имя пользователя
  NAME_ACCEPTED, //имя принято
  TEXT, //текстовое сообщение
  USER_ADDED, //пользователь добавлен
  USER_REMOVED; //пользователь удален
}
