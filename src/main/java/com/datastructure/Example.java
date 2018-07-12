package com.datastructure;

import java.util.ArrayList;

public class Example {
  public static void main(String args[]) {
    final Object a = new Object();
    final Object b = new Object() {
      @Override
      public int hashCode() {
        return 42;
      }
    };

    System.out.println(a.equals(b));

    // use this kind of map...
    final HashMap<Object, Integer> map = new HashMap<>();

    // table.containsValue\((.+),\d+\)
  }
}
