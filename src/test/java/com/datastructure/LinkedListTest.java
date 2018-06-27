package com.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.NoSuchElementException;

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
    LinkedList id = new LinkedList();
    list.insert("one");
    list.insert("tow");
    id.insert("one");
    id.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(id.contains("one"));
    assertTrue(id.contains("tow"));
    assertTrue(list.equals(id));
    assertEquals("one", list.get(0));
    assertEquals("tow", list.get(1));
    list.insertBefore("tow", "one and a half");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("one and a half"));
    assertTrue(list.contains("tow"));
    assertEquals("one", list.get(0));
    assertEquals("one and a half", list.get(1));
    assertEquals("tow", list.get(2));
  }

  @Test(expected = RuntimeException.class)
  public void testInsertBeforeInEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.insertBefore("one", "tow");
  }

  @Test
  public void testInsertAfter() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertEquals("one", list.get(0));
    assertEquals("tow", list.get(1));
    list.insertAfter("one", "one and a half");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("one and a half"));
    assertEquals("one", list.get(0));
    assertEquals("one and a half", list.get(1));
    assertEquals("tow", list.get(2));

  }

  @Test(expected = RuntimeException.class)
  public void testInsertAfterInEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.insertAfter("one", "tow");
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

  /**
   * inserts first item in the list  using insert()
   */
  @Test
  public void testInsertFirstItem() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.insert("one");
    assertTrue(list.contains("one"));
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

  @Test(expected = RuntimeException.class)
  public void testRemoveFirstFromEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.removeFirst();
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

  /**
   * removes the first item in the list using remove()
   */
  @Test
  public void testRemoveFirstItem() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("one", list.remove("one"));
    assertFalse("expected not contain one", list.contains("one"));
    assertTrue("expected to contain tow", list.contains("tow"));
    assertTrue("expected to contain three", list.contains("three"));
  }

  /**
   * removes the last item in the list using remove()
   */
  @Test
  public void testRemoveLastItem() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("three", list.remove("three"));
    assertTrue("expected to contain one", list.contains("one"));
    assertTrue("expected to contain tow", list.contains("tow"));
    assertFalse("expected not contain three", list.contains("three"));
  }

  @Test(expected = RuntimeException.class)
  public void testRemoveFromEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.remove("four");
  }

  @Test(expected = NoSuchElementException.class)
  public void testRemoveNonExistedItem() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("three"));
    assertFalse("expected not to contain four", list.contains("four"));
    list.remove("four");
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

  @Test(expected = RuntimeException.class)
  public void testRmoveLastFromEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.removeLast();
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
    assertEquals("one", list.getFirst());
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));

  }

  @Test(expected = RuntimeException.class)
  public void testGetFristFromEpmtyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.getFirst();
  }

  @Test
  public void testGetLast() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("three", list.getLast());
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
  }

  @Test(expected = RuntimeException.class)
  public void testGetLastFromEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.removeLast();
  }

  @Test
  public void testSize() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals(3l, list.size());

  }

  @Test
  public void testSizeOfEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
  }

  @Test
  public void testGet() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals("tow", list.get(1));

  }

  @Test(expected = RuntimeException.class)
  public void testGetFromEmptyList() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    list.get(0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetNonExistedItem() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertEquals(3, list.size());
    list.get(4);
  }

  @Test
  public void testEquals() {
    LinkedList list = new LinkedList();
    LinkedList id = new LinkedList();
    list.insert("one");
    list.insert("tow");
    id.insert("one");
    id.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(id.contains("one"));
    assertTrue(id.contains("tow"));
    assertTrue(list.equals(id));
  }

  @Test
  public void testEqualsEmptyList() {
    LinkedList list = new LinkedList();
    LinkedList id = new LinkedList();
    assertTrue(list.isEmpty());
    assertTrue(id.isEmpty());
    assertTrue(list.equals(id));
  }

  @Test
  public void testEqualsNotEqualySizedLists() {
    LinkedList list = new LinkedList();
    LinkedList id = new LinkedList();
    list.insert("one");
    list.insert("tow");
    list.insert("three");
    id.insert("one");
    id.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.contains("three"));
    assertTrue(id.contains("one"));
    assertTrue(id.contains("tow"));
    assertFalse(list.equals(id));
  }

  @Test
  public void testEqualsToNullObject() {
    LinkedList list = new LinkedList();
    LinkedList id = new LinkedList();
    list.insert("one");
    list.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(id.isEmpty());
    assertFalse(list.equals(id));
  }

  @Test
  public void testEqualsSelf() {
    LinkedList list = new LinkedList();
    list.insert("one");
    list.insert("tow");
    assertTrue(list.contains("one"));
    assertTrue(list.contains("tow"));
    assertTrue(list.equals(list));
  }

}
