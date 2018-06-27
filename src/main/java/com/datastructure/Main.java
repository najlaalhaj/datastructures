package com.datastructure;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    list.insertAfter("tow", "tow tow");
    list.insertBefore("tow", "one and a half");
    list.insertFirst("half");
    System.out.println("Is the list conrains four : " + list.contains("four"));
    System.out.println("Is the list contains one : " + list.contains("one"));
    System.out.println("Is the list contains three : " + list.contains("three"));
    System.out.println("The first item in the list is : " + list.getFirst());
    System.out.println("The last item in is the list is : " + list.getLast());
    System.out.println("Printing all items in the list :");
    list.getAll();
    System.out.println("Removing the first item : " + list.removeFirst());
    System.out.println("Printing the list after removing the first item : ");
    list.getAll();
    System.out.println("Removing the last item in the list : " + list.removeLast());
    System.out.println("Printing the list after removing the last item : ");
    list.getAll();
    System.out.println(list.remove("tow"));
    System.out.println(list.contains("tow"));
      java.util.LinkedList<String> list1 = new java.util.LinkedList<>();
      list1.add("one");
      list1.add("one");
      list1.add("one");
      ArrayList<String> array = new ArrayList<>();
      array.add("one");
      array.add("one");
      array.add("one");
      System.out.println(list.equals(array));

  }
}
