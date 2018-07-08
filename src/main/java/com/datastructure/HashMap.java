package com.datastructure;

import java.util.NoSuchElementException;

public class HashMap<String, Integer> {
  private Node[] table;
  private final int capacity = 100;

  HashMap() {
    table = new Node[capacity];

  }

  public int hashCode(Object key) {
    if(key.equals("one")){
      return 82;
    }
    if(key.equals("tow")){
      return 82;
    }
    if(key.equals("three")){
      return 82;
    }
    return (key.hashCode()%capacity);
  }

  public boolean containsKey(Object key) {
    Node<String, Integer> temp;
    int hash;
    if(table.length==0) return false;
    hash=this.hashCode(key);
    temp=table[hash];
    if(table[hash]==null) return false;
    while(!(temp==null)&&(!(temp.key.equals(key)))){
      temp=temp.next;
    }
    return (temp!=null);
  }

  public boolean containsValue(Object key, Object value){
    Node<String, Integer> temp;
    int hash;
    if(table.length==0) return false;
    hash=this.hashCode(key);
    if(table[hash]==null) return false;
    temp=table[hash];
    while((temp!=null)&&(!(temp.value.equals(value)))){
      temp=temp.next;
    }
    return (temp != null);
  }

  public boolean put(Object key, Object value){
    int hash=this.hashCode(key);
    if (this.table[hash]==null) {
      table[hash]=new Node<>(key,value,table[hash]);
      return true;
    }
    if(this.containsKey(key)){
      return false;
    }
    Node<String, Integer> temp=table[hash];
    while (temp.next!= null){
      temp=temp.next;
    }
    temp.next = new Node<String, Integer>(key,value,temp.next);
    return true;
  }

  public boolean removeValue(Object key, Object value){
    Node<String, Integer> temp;
    Node<String, Integer> prev;
    int hash;
    if(table.length==0) throw new NoSuchElementException("The Map table is empty");
    hash=this.hashCode(key);
    if (table[hash]==null) throw new NoSuchElementException("Value not found");
    temp=table[hash];
    prev=null;
    while((temp!=null)&&(!(temp.value.equals(value)))){
      prev=temp;
      temp=temp.next;
    }
    if((temp.value.equals(table[hash].value))){
      table[hash]=table[hash].next;
      return true;
    }
    if (temp.next==null){
      prev.next=null;
      return true;
    }
    prev.next=temp.next;
    return true;
  }

  public Object getValue(Object key){
    int hash;
    Node<String, Integer> temp;
    if(table.length==0) throw new RuntimeException("Empty map");
    hash=this.hashCode(key);
    if(table[hash]==null) throw new NoSuchElementException("value not found");
    if(table[hash].key.equals(key)){
      return (Object) table[hash].value;
    }
    temp=table[hash];
    while((temp!=null)&&(!(temp.key.equals(key)))){
      temp=temp.next;
    }
    if(temp!=null){
      return temp.value;
    }
    return null;
  }

    private class Node<String, Integer> {
      Object key;
      Object value;
      Node<String, Integer> next;

      Node(Object key,Object value, Node<String, Integer> next) {
        this.key = key;
        this.value = value;
        this.next = next;
      }
    }
  }
