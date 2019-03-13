package com.datastructure;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

   Runtime singleton = Runtime.getRuntime();
   singleton.gc();
    System.out.println(singleton);
    Runtime anotherSingleton = Runtime.getRuntime();
    System.out.println(anotherSingleton);
    if (singleton == anotherSingleton) System.out.println("they are the same!");
  }

}
