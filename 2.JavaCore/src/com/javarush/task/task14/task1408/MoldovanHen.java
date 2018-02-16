package com.javarush.task.task14.task1408;

/**
 * @author Ivanov
 * @since 09.01.2018.
 */
public class MoldovanHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {
    return 3;
  }

  @Override
  String getDescription() {
    return super.getDescription()+String.format(" Моя страна - %s. Я несу %d яиц в месяц.",Country.MOLDOVA,getCountOfEggsPerMonth());
  }

  public static class Factory  implements FactoryI<Hen> {
    @Override
    public Hen create() { return new MoldovanHen ();}
  }
}
