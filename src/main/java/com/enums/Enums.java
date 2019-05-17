package com.enums;

import java.util.Arrays;

public class Enums {

  public static void main(String[] args) {

      WeekDay[] values = WeekDay.values();
      for (WeekDay dayType :values ) {
      System.out.println(dayType.name()+" is a "+dayType.getDayType());
      }
    Arrays.stream(values).forEach(value -> System.out.println(value));
  }
   }

