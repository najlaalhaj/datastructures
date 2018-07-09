package com.datastructure;

import java.util.NoSuchElementException;

public class HashMap<String, Integer> {

  private Node[] table;
  private final int capacity = 100;

  HashMap() {
    table = new Node[capacity];

  }

  public int hashCode(String key) {
    if ((key.equals("one")) || (key.equals("tow")) || key.equals("three")) {
      return 82;
    }
    return (key.hashCode() % capacity);

  }

  public boolean containsKey(String key) {
    Node<String, Integer> temp;
    int hash;
    if (table.length == 0) {
      return false;
    }
    hash = this.hashCode(key);
    temp = table[hash];
    if (table[hash].isEmpty()) {
      return false;
    }
    while (!(temp == null) && (!(temp.getKey().equals(key)))) {
      temp = temp.next;
    }
    return (temp != null);
  }

  public boolean containsValue(String key, Integer value) {
    Node<String, Integer> temp;
    int hash;
    if (table.length == 0) {
      return false;
    }
    hash = this.hashCode(key);
    if (table[hash].isEmpty()) {
      return false;
    }
    temp = table[hash];
    while ((temp != null) && (!(temp.getValue().equals(value)))) {
      temp = temp.next;
    }
    return (temp != null);
  }

  /**
   * Insert a value into the table.
   *
   * @return {@code true} if the insertion is successful.
   */
  public boolean put(String key, Integer value) {
    int hash = this.hashCode(key);

    Node<String, Integer> temp = table[hash];
    Node<String, Integer> prev = null;

    while (temp != null && !temp.key.equals(key)) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null && prev == null) {
      table[hash] = new Node<>(key, value, null);
    } else if (temp == null && prev != null) {
      prev.next = new Node<>(key, value, null);
    } else {
      temp.value = value;
    }

    return true;
  }

  public boolean removeValue(String key, Integer value) {
    Node<String, Integer> temp;
    Node<String, Integer> prev;
    int hash;
    if (table.length == 0) {
      throw new NoSuchElementException("The Map table is empty");
    }
    hash = this.hashCode(key);
    if (table[hash].isEmpty()) {
      throw new NoSuchElementException("Value not found");
    }
    temp = table[hash];
    prev = null;
    while ((temp != null) && (!(temp.getValue().equals(value)))) {
      prev = temp;
      temp = temp.next;
    }
    if ((temp.getValue().equals(table[hash].getValue()))) {
      table[hash] = table[hash].next;
      return true;
    }
    if (temp.next == null) {
      prev.next = null;
      return true;
    }
    prev.next = temp.next;
    return true;
  }

  public Integer getValue(String key) {
    int hash;
    Node<String, Integer> temp;
    if (table.length == 0) {
      throw new RuntimeException("Empty map");
    }
    hash = this.hashCode(key);
    if (table[hash].isEmpty()) {
      throw new NoSuchElementException("value not found");
    }
    if (table[hash].getKey().equals(key)) {
      return (Integer) table[hash].value;
    }
    temp = table[hash];
    while ((temp != null) && (!(temp.getKey().equals(key)))) {
      temp = temp.next;
    }
    if (temp != null) {
      return (Integer) temp.value;
    }
    return null;
  }

  private class Node<String, Integer> {

    String key;
    Integer value;
    Node<String, Integer> next;

    Node(String key, Integer value, Node<String, Integer> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    boolean isEmpty() {
      if ((key == null) && (value == null)) {
        return true;
      }
      return false;
    }

    String getKey() {
      return this.key;
    }

    Integer getValue() {
      return this.value;
    }
  }
}
