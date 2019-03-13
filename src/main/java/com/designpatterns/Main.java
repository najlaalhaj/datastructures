package com.designpatterns;

public class Main {

  public static void main(String[] args) {

      DbSingleton dbSingleton = DbSingleton.getDbSingleton();
    System.out.println(dbSingleton);

    LunchOrder.Builder builder = new LunchOrder.Builder();
    LunchOrder lunchOrder = builder.bread("bread").condiment("condiment").dressing("dressing").meat("meat").build();
    System.out.println(lunchOrder.getBread());
    System.out.println(lunchOrder.getCondiment());
    System.out.println(lunchOrder.getMeat());
    System.out.println(lunchOrder.getDressing());
  }
}
