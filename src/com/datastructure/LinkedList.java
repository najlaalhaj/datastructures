package com.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    public LinkedList(){
        head=null;
    }

    /**
     * insert a string at the beginig of the list
     * @param item
     */
    public void insertFirst(String item){
        head=new Node(item,head);
    }

    public boolean contains(String item){
        Node temp=head;
        if(head==null) return false;
        while(!(temp==null)&&(!temp.item.equals(item)))
            temp=temp.tail;
        if(temp==null) return false;
        return true;
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
        Node temp=head;
        if(head==null) throw new RuntimeException("List is empty");
        while (!(temp == null) && !(temp.item.equals(key))) temp = temp.tail;
        if(temp!= null)
        temp = new Node(toInsert, temp);
    }

    public void insertBefore(String key,String toInsert){
        Node temp=head;
        Node prev=null;
        if(head==null) throw new RuntimeException("empty list");
        while(!(temp==null)&&!(temp.item.equals(key))){
            prev=temp;
            temp=temp.tail;
        }
        if(temp!= null)
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
        String result=null;
        if (head== null) throw new RuntimeException("can not delete element. The list is empty");
        if(head!=null) {
            result=head.item;
            head= head.tail;
            return result;
        }
        while(!(temp==null)&&!(temp.item.equals(item))) {
            prev=temp;
            temp=temp.tail;
        }
        if(temp==null) throw new RuntimeException("elment not found");
        result=temp.item;
        prev.tail=temp.tail;
        return result;
    }
    public String removeFirst(){
        String result=null;
        if(head==null){
            throw new RuntimeException("can not delete, the list is empty");
        }
        if(head != null){
            result=head.item;
            head=head.tail;
            return result;
        }
        return result;
    }

    public String removeLast(){
        String result= null;
        Node temp= head;
        Node prev = null;
        if(head==null) throw new RuntimeException("can not delete from an empty list");
        while(temp != null) {
            prev = temp;
            temp = temp.tail;
        }
        result=prev.item;
        prev.tail=temp;
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
