package com.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.naming.OperationNotSupportedException;

public class LinkedList<E> implements List<E> {

  private Node<E> head;

  public LinkedList() {
    head = null;
  }

  /**
   * gets the head refrence to the first node in the list
   *
   * @return head
   */
  private Node<E> getHead() {
    return head;
  }

  public boolean isEmpty() {
    if (head == null) {
      return true;
    }
    return false;
  }

  /**
   * insert a E at the beginig of the list
   */
  public void insertFirst(E item) {
    head = new Node<E>(item, head);
  }

  /**
   * checks if a secific item is in the list
   *
   * @return true if item is in the list
   */
  public boolean contains(Object item) {
    Node<E> temp = head;
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

  public int size() {
    int count = 0;
    Node<E> temp = head;
    if (this.isEmpty()) {
      return 0;
    }
    while (temp != null) {
      count += 1;
      temp = temp.tail;
    }
    return count;
  }

  /**
   * append a E to the end of the list
   */
  public void insert(E item) {
    if (this.isEmpty()) {
      insertFirst(item);
    } else {
      Node<E> temp = head;
      while (!(temp.tail == null)) {
        temp = temp.tail;
      }
      temp.tail = new Node<E>(item, temp.tail);
    }
  }

  /**
   * inserts toInsert E after key E
   */
  public void insertAfter(E key, E toInsert) {
    Node<E> temp = head;
    if (this.isEmpty()) {
      throw new RuntimeException("List is empty");
    }
    while (!(temp == null) && !(temp.item.equals(key))) {
      temp = temp.tail;
    }
    if (temp != null) {
      temp.tail = new Node<E>(toInsert, temp.tail);
    }
  }

  /**
   * inserts toInsert E before item E
   */
  public void insertBefore(E key, E toInsert) {
    Node<E> temp = head;
    Node<E> prev = null;
    if (this.isEmpty()) {
      throw new RuntimeException("empty list");
    }
    while (!(temp == null) && !(temp.item.equals(key))) {
      prev = temp;
      temp = temp.tail;
    }
    if (temp != null) {
      prev.tail = new Node<E>(toInsert, prev.tail);
    }
  }

  /**
   * removes the first occurence of the item E
   *
   * @return the removed item
   */
  public boolean remove(Object item) {
    Node<E> temp = head;
    Node<E> prev = temp;
    E result = null;
    if (item.getClass() != this.getClass()) {
      throw new RuntimeException();
    }
    item = (E) item;
    if (this.isEmpty()) {
      throw new RuntimeException("can not delete element. The list is empty");
    }
    while (!(temp == null) && !(temp.item.equals(item))) {
      prev = temp;
      temp = temp.tail;
    }
    if (temp == null) {
      throw new NoSuchElementException(item + " not in the list");
    }
    if ((temp.item).equals(head.item)) {
      result = removeFirst();
      return true;
    }
    if (temp.tail == null) {
      result = removeLast();
      return true;
    }
    prev.tail = temp.tail;
    return true;
  }

  /**
   * rempves the first item in the list
   *
   * @return the removed item
   */
  public E removeFirst() {
    E result = null;
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
  public E removeLast() {
    E result = null;
    Node<E> temp = head;
    Node<E> prev = null;
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
      Node<E> temp = head;
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
  public E getFirst() {
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
  public E getLast() {
    Node<E> temp = head;
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
   * @return item
   */
  public E get(int index) {
    E result = null;
    Node<E> temp = head;
    if (this.isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    if (index > this.size()) {
      throw new IndexOutOfBoundsException("Index does not exist");
    }
    for (int i = 0; i <= index; i++) {
      result = temp.item;
      temp = temp.tail;
    }
    return result;
  }

  public E set(final int index, final E element) {
    return null;
  }

  public void add(final int index, final E element) {

  }

  public E remove(final int index) {
    return null;
  }

  public int indexOf(final Object o) {
    return 0;
  }

  public int lastIndexOf(final Object o) {
    return 0;
  }

  public ListIterator<E> listIterator() {
    return new LinkedListIterator<E>();
  }

  public ListIterator<E> listIterator(final int index) {
    return null;
  }

  public List<E> subList(final int fromIndex, final int toIndex) {
    return null;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof List)) {
      return false;
    }
    Iterator<E> e1 = iterator();
    Iterator<?> e2 = ((List<?>) object).iterator();
    while (e1.hasNext() && e2.hasNext()) {
      E o1 = e1.next();
      Object o2 = e2.next();
      if (!(o1 == null ? o2 == null : o1.equals(o2))) {
        return false;
      }
    }
    return !(e1.hasNext() || e2.hasNext());
  }

  public Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  public Object[] toArray() {
    return new Object[0];
  }

  public <T> T[] toArray(final T[] a) {
    return null;
  }

  public boolean add(final E e) {
    return false;
  }

 /* public boolean remove(final Object o) {
    return false;
  }*/

  public boolean containsAll(final Collection<?> c) {
    return false;
  }

  public boolean addAll(final Collection<? extends E> c) {
    return false;
  }

  public boolean addAll(final int index, final Collection<? extends E> c) {
    return false;
  }

  public boolean removeAll(final Collection<?> c) {
    return false;
  }

  public boolean retainAll(final Collection<?> c) {
    return false;
  }

  public void clear() {

  }

  /**
   * represents a node object in the list
   */
  private static class Node<E> {

    private E item;
    private Node<E> tail;

    Node(E item, Node<E> tail) {
      this.item = item;
      this.tail = tail;
    }

  }

  private class LinkedListIterator<E> implements ListIterator<E> {

    private Node<E> position;
    private Node<E> previous;

    public LinkedListIterator() {
      position = (LinkedList.Node) head;
      previous = null;
    }

    public boolean hasNext() {
      return (position != null);
    }

    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E result = position.item;
      position = position.tail;
      return result;
    }

    public boolean hasPrevious() {
      return previous != null;
    }

    public E previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      E result = previous.item;
      previous = previous.tail;
      return result;
    }

    public int nextIndex() {
      return 0;
    }

    public int previousIndex() {
      return 0;
    }

    public void reset() {
      throw new UnsupportedOperationException();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public void set(final E e) {
      throw new UnsupportedOperationException();
    }

    public void add(final E e) {
      throw new UnsupportedOperationException();

    }
  }

}



