package com.datastructure;

import java.util.Iterator;

public class LinkedList {

    private Node head;
    public LinkedList(){
        head=null;
    }
    public void insertFirst(String item){
        head=new Node(item,head);
    }

    /**
     * append a string to the end of the list
     * @param item
     */
    public void insert(String item){
        if(head==null) {
            insertFirst(item);
        }else{
            Node temp=head;
            while (!(temp.tail == null)) {
                temp=temp.tail;
            }
            temp=new Node(item,null);
        }
    }

    public void insertAfter(String key,String toInsert) {
        Node temp = head;
        while (!(temp == null) && !(temp.item.equals(key))) temp = temp.tail;
        temp = new Node(toInsert, temp);
    }

    public void insertBefore(String key,String toInsert){
        Node temp=head;
        Node prev=null;
        if(temp==null)
        while(!(temp==null)&&!(temp.item.equals(key))){
            prev=temp;
            temp=temp.tail;
        }
        prev=new Node(toInsert,prev);
    }

    /**
     * removes the first occurence of the item string
     * @param item
     * @return the removed item
     */
    public String remove(String item){
        Node temp=head;
        Node prev=null;
        String result;
        if (temp== null) throw new RuntimeException();
        while(!(temp.item.equals(item))) temp=temp.tail;
        result=temp.item;
        temp=temp.tail;
        prev=temp;
        return result;
    }

    private static class Node{
        private String item;
        private Node tail;

        Node(String item,Node head){
            this.item=item;
            this.tail=head;
        }
    }


}
