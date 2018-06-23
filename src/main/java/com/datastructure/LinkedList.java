package com.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList {

  private Node head;

  public LinkedList() {
    head = null;
  }

  /**
   * gets the head refrence to the first node in the list
   *
   * @return head
   */
  private Node getHead() {
    return head;
  }

  public boolean isEmpty() {
    if (head == null) {
      return true;
    }
    return false;
  }

  /**
   * insert a string at the beginig of the list
   */
  public void insertFirst(String item) {
    head = new Node(item, head);
  }

  /**
   * checks if a secific item is in the list
   *
   * @return true if item is in the list
   */
  public boolean contains(String item) {
    Node temp = head;
    if (this.isEmpty()) {
      return false;
    }
    while (!(temp == null) && (!temp.item.equals(item))) {
      temp = temp.tail;
    }
    if (temp == null) {
      return false;
    }
    return true;
  }

  public int size(){
      int count=0;
      Node temp=head;
      if(this.isEmpty()) return 0;
      while(temp!=null) {
          count += 1;
          temp=temp.tail;
      }
      return count;
    }
  /**
   * append a string to the end of the list
   */
  public void insert(String item) {
    if (this.isEmpty()) {
      insertFirst(item);
    } else {
      Node temp = head;
      while (!(temp.tail == null)) {
        temp = temp.tail;
      }
      temp.tail = new Node(item, null);
    }
  }

  /**
   * inserts toInsert string after key string
   */
  public void insertAfter(String key, String toInsert) {
    Node temp = head;
    if (this.isEmpty()) {
      throw new RuntimeException("List is empty");
    }
    while (!(temp == null) && !(temp.item.equals(key))) {
      temp = temp.tail;
    }
    if (temp != null) {
      temp.tail = new Node(toInsert, temp.tail);
    }
  }

  /**
   * inserts toInsert string before item string
   */
  public void insertBefore(String key, String toInsert) {
    Node temp = head;
    Node prev = null;
    if (this.isEmpty()) {
      throw new RuntimeException("empty list");
    }
    while (!(temp == null) && !(temp.item.equals(key))) {
      prev = temp;
      temp = temp.tail;
    }
    if (temp != null) {
      prev.tail = new Node(toInsert, prev.tail);
    }
  }

  /**
   * removes the first occurence of the item string
   *
   * @return the removed item
   */
  public String remove(String item) {
    Node temp = head;
    Node prev = temp;
    String result = null;
    if (this.isEmpty()) {
      throw new RuntimeException("can not delete element. The list is empty");
    }
    while (!(temp==null) && !(temp.item.equals(item))) {
      prev = temp;
      temp = temp.tail;
    }
    if (temp== null) throw new NoSuchElementException(item+" not in the list");
    if ((temp.item).equals(head.item)){
        result=removeFirst();
        return result;
    }
    if (temp.tail==null) {
        result = removeLast();
        return result;
    }
    result= temp.item;
    prev.tail=temp.tail;
    return  result;
  }

  /**
   * rempves the first item in the list
   *
   * @return the removed item
   */
  public String removeFirst() {
    String result = null;
    if (this.isEmpty()) {
      throw new RuntimeException("can not delete, the list is empty");
    }
    result = head.item;
    head = head.tail;
    return result;

  }

  /**
   * removes the last item in the list
   *
   * @return the removed item
   */
  public String removeLast() {
    String result = null;
    Node temp = head;
    Node prev = null;
    if (this.isEmpty()) {
      throw new RuntimeException("can not delete from an empty list");
    }
    while (temp.tail != null) {
      prev = temp;
      temp = temp.tail;
    }
    result = temp.item;
    prev.tail = null;
    return result;
  }

  /**
   * get all items in the list
   */
  public void getAll() {
    if (this.isEmpty()) {
      throw new RuntimeException("Empty list");
    } else {
      Node temp = head;
      while (!(temp == null)) {
        System.out.println(temp.item);
        temp = temp.tail;
      }
    }
  }

  /**
   * gets the first item in the list
   *
   * @return first item
   */
  public String getFirst() {
    if (this.isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    return head.item;
  }

  /**
   * gets the last item in the list
   *
   * @return last item
   */
  public String getLast() {
    Node temp = head;
    if (this.isEmpty()) {
      throw new RuntimeException("Empty list");
    }
    while (!(temp.tail == null)) {
      temp = temp.tail;
    }
    return temp.item;
  }

    /**
     * get specific item in the list
     *
     * @param  index
     * @return item
     */
  public String get(int index){
      String result=null;
      Node temp=head;
      if(this.isEmpty()) throw new RuntimeException("Empty List");
      if(index>this.size()) throw new IndexOutOfBoundsException("Index does not exist");
      for(int i=0;i<=index;i++) {
          result = temp.item;
          temp = temp.tail;
              }
              return result;
          }

          /**
           * represents a node object in the list
           */
          private static class Node {

              private String item;
              private Node tail;

              Node(String item, Node head) {
                  this.item = item;
                  this.tail = head;
              }
          }
      }


