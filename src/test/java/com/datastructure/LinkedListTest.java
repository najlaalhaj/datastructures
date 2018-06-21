package com.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {

  @Test
  public void testInsertFirst() {
    LinkedList list = new LinkedList();
    assertTrue("true", list.isEmpty());
    list.insertFirst("one");
    assertTrue("one", list.contains("one"));
  }

  @Test
  public void testInsertBefore() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertEquals("one", list.get(1));
    assertEquals("tow", list.get(2));
    list.insertBefore("tow", "one and a half");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("one and a half"));
    assertTrue(list.contains("tow"));
    assertEquals("one", list.get(1));
    assertEquals("one and a half", list.get(2));
    assertEquals("tow", list.get(3));
  }

  @Test
  public void testInsertAfter() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertEquals("one", list.get(1));
    assertEquals("tow", list.get(2));
    list.insertAfter("one", "one and a half");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("one and a half"));
    assertEquals("one", list.get(1));
    assertEquals("one and a half", list.get(2));
    assertEquals("tow", list.get(3));

  }

  @Test
  public void testInsert() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertFalse("expect list not to contain four", list.contains("four"));
  }

  @Test
  public void testRemoveFirst() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("Expect a string one", "one", list.removeFirst());
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertFalse(list.contains("one"));
  }

  @Test
  public void testRemove() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue("Expects to contain one", list.contains("one"));
    assertTrue("Expects to contain tow", list.contains("tow"));
    assertTrue("Expects to contain three", list.contains("three"));
    assertEquals("tow", list.remove("tow"));
    assertTrue(list.contains("one"));
    assertTrue(list.contains("three"));
    assertFalse("expect not to contain tow", list.contains("tow"));

  }

  @Test
  public void testRemoveLast() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    list.removeLast();
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertFalse("expect not to contain three", list.contains("three"));
  }

  @Test
  public void testGetFirst() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("one", list.get(1));
    assertEquals("one", list.getFirst());
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("one", list.get(1));

  }
}
