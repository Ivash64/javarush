package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

/**
 * @author Ivanov
 * @since 18.04.2018.
 */
public class ModelData {
  private User activeUser;
  private boolean displayDeletedUserList;

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
  }

  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public boolean isDisplayDeletedUserList() {
    return displayDeletedUserList;
  }

  public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
    this.displayDeletedUserList = displayDeletedUserList;
  }
}
