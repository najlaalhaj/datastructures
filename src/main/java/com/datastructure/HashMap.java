package com.datastructure;

import java.util.NoSuchElementException;

public class HashMap<K, V> {
  private Node<K, V>[] table;
  private final int capacity = 100;

  @SuppressWarnings("unchecked")
  HashMap() {
    table = new Node[capacity];

  }

  public int hashCode(K key) {

    return (key.hashCode() % capacity);
  }

  public boolean containsKey(K key) {
    Node<K, V> temp;
    int hash;
    if (table.length == 0) {
      return false;
    }
    hash = this.hashCode(key);
    temp = table[hash];
    if (table[hash]==null) {
      return false;
    }
    while (!(temp == null) && (!(temp.getKey().equals(key)))) {
      temp = temp.next;
    }
    return (temp != null);
  }


  public boolean containsValue(K key) {
    return getValue(key) != null;
  }

  public boolean put(K key, V value) {

    int hash = this.hashCode(key);

    Node<K, V> temp = table[hash];
    Node<K, V> prev = null;

    while (temp != null && !temp.key.equals(key)) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null){
      if ( prev != null) {
      prev.next = new Node<>(key, value, null);
    } else {      table[hash] = new Node<>(key, value, null);
      }
    }else{
        temp.value = value;
    }
    return true;
  }

  public boolean removeValue(K key) {
    Node<K, V> temp;
    Node<K, V> prev;
    int hash;
    if (table.length == 0) {
      throw new NoSuchElementException("The Map table is empty");
    }
    hash = this.hashCode(key);
    if (table[hash] == null) {
      throw new NoSuchElementException("Value not found");
    }
    temp = table[hash];
    prev = null;
    while ((temp != null) && (!(temp.getKey().equals(key)))) {
      prev = temp;
      temp = temp.next;
    }
    if ((temp.getValue().equals(table[hash].getValue()))) {
      table[hash] = table[hash].next;
      return true;
    }

    prev.next = temp.next;
    return true;
  }

  public V getValue(K key) {
    int hash;
    Node<K, V> temp;

    // TODO: use the actual length of the map when we have it.

    if (table.length == 0) {
      throw new RuntimeException("Empty map");
    }
    hash = this.hashCode(key);

    temp = table[hash];
    while (temp != null && !temp.getKey().equals(key)) {
      temp = temp.next;
    }
    if (temp != null) {
      return temp.value;
    }
    return null;
  }

  private class Node<K, V> {

    K key;
    V value;
    Node<K, V> next;

    Node(K key, V value, Node<K, V> next) {
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

    K getKey() {
      return this.key;
    }

    V getValue() {
      return this.value;
    }
  }

}
