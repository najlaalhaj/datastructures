package com.datastructure;

public class HashMap<String,Integer> {
  private Node<String,Integer>[] table;
  private final int capacity=10;
  HashMap(){
    table = new Node[capacity];
  }
  private int hashCode(String key){
    return key.hashCode();
  }

  public boolean isEmpty(){
    if(table.length==0) return true;
    return false;
  }

  public boolean containsKey(String key){
    int hash= key.hashCode();
    Node<String,Integer> tail;
    tail=table[hash];
    if (!(tail.isEmpty())){
      if((tail!=null)&&(tail.Key!=key))

    }
    return false;
  }
  private class Node<String,Integer>{
    String Key;
    Integer value;
    Node<String,Integer> next;

    Node(String key,Integer vlaue,Node<String,Integer> next){
      this.Key= key;
      this.value= value;
      this.next=next;
    }
  }
}
