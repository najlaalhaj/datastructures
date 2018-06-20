package com.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {

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
  public void testRemoveFirst(){
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("Expect a string one","one",list.removeFirst());
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertFalse(list.contains("one"));
  }
}
