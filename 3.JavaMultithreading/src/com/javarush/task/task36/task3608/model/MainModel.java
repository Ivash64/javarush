package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;


/**
 * @author Ivanov
 * @since 18.04.2018.
 */
public class MainModel implements Model  {
  private UserService userService = new UserServiceImpl();
  private ModelData modelData = new ModelData();

  @Override
  public ModelData getModelData() {
    return modelData;
  }

  @Override
  public void loadUsers() {
    modelData.setDisplayDeletedUserList(false);
    modelData.setUsers(userService.getUsersBetweenLevels(1,100));
  }

  @Override
  public void loadDeletedUsers() {
    modelData.setDisplayDeletedUserList(true);
    modelData.setUsers(userService.getAllDeletedUsers());
  }
}
