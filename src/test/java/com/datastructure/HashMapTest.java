package com.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void containsValue() throws Exception {
        HashMap<String, Integer> table = new HashMap<>();
        assertTrue(table.put("one",1));
        assertTrue(table.containsValue("one",1));
    }
    @Test
    public void testContainsNonExistingValue(){
        HashMap<String, Integer> table = new HashMap<>();
        table.put("one",1);
        assertTrue(table.containsValue("one",1));
        assertFalse(table.containsValue("tow",2));
    }
    @Test
    public void testContainsKey(){
        HashMap<String, Integer> table = new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("four",1);
        assertTrue(table.containsKey("one"));
        assertTrue(table.containsKey("tow"));
        assertTrue(table.containsKey("four"));
    }

    @Test
    public void testPut(){
        HashMap<String, Integer> table = new HashMap<>();
        table.put("one",1);
        table.put("four",4);
        assertTrue(table.containsKey("one"));
        assertTrue(table.containsKey("four"));
    }

    @Test
    public void testPutCollision(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
    }
    @Test
    public void testPutDuplicateKey(){
        HashMap<String, Integer> table = new HashMap<>();
        table.put("one",1);
        assertTrue(table.containsKey("one"));
        assertFalse(table.put("one",1));
    }

    @Test
    public void testRemoveCollisionFirst(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
        table.removeValue("one",1);
        assertFalse(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
    }

    @Test
    public void testRemoveCollision(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
        table.removeValue("tow",2);
        assertTrue(table.containsValue("one",1));
        assertFalse(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
    }

    @Test
    public void testRemoveCollisionLast(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
        table.removeValue("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertFalse(table.containsValue("three",3));
    }

    @Test
    public void testRemove(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("four",4);
        table.put("five",5);
        assertTrue(table.containsKey("one"));
        assertTrue(table.containsKey("four"));
        assertTrue(table.containsKey("five"));
        table.removeValue("four",4);
        assertTrue(table.containsKey("one"));
        assertFalse(table.containsKey("four"));
        assertTrue(table.containsKey("five"));
    }
    @Test
    public void testGetValueCollisionFirst(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
        int value= (int) table.getValue("one");
        assertEquals(1,value);
    }

    @Test
    public void testGetValueCollision(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
        int value= (int) table.getValue("tow");
        assertEquals(2,value);
    }

    @Test
    public void testGetValueCollisionLast(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("tow",2));
        assertTrue(table.containsValue("three",3));
        int value= (int) table.getValue("three");
        assertEquals(3,value);
    }

    @Test
    public void testGetValue(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("four",4);
        table.put("five",5);
        assertTrue(table.containsValue("one",1));
        assertTrue(table.containsValue("four",4));
        assertTrue(table.containsValue("five",5));
        int value= (int) table.getValue("four");
        assertEquals(4,value);
    }
}