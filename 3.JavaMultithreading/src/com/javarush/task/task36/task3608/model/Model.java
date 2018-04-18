package com.javarush.task.task36.task3608.model;

/**
 * @author Ivanov
 * @since 18.04.2018.
 */
public interface Model {
  ModelData getModelData();
  void loadUsers();
  void loadDeletedUsers();
}
