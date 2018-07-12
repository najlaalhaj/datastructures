package com.datastructure;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HashTableTest {
    @Test
    public void testPut(){
        HashTable hashTable = new HashTable();
        hashTable.put("one");
        assertTrue(hashTable.contains("one"));
    }

    @Test
    public void testPutDuplicate(){
        HashTable hashTable = new HashTable();
        assertTrue(hashTable.put("one"));
        assertFalse(hashTable.put("one"));
    }
    @Test
    public void testRemove(){
        HashTable hashTable = new HashTable();
        hashTable.put("one");
        hashTable.put("tow");
        hashTable.put("three");
        hashTable.put("four");
        assertTrue(hashTable.contains("one"));
        assertTrue(hashTable.contains("tow"));
        assertTrue(hashTable.contains("three"));
        assertTrue(hashTable.contains("four"));
        assertEquals(true,hashTable.remove("tow"));
    }
    @Test
    public void testEquals(){
        HashTable hashTable = new HashTable();
        HashTable hashTable1 = new HashTable();
        hashTable.put("one");
        hashTable.put("tow");
        hashTable1.put("one");
        hashTable1.put("tow");
        assertTrue(hashTable.equals(hashTable1));
    }

    @Test
    public void testEqualsSymetric(){
        HashTable hashTable = new HashTable();
        HashTable hashTable1 = new HashTable();
        hashTable.put("one");
        hashTable.put("tow");
        hashTable1.put("one");
        hashTable1.put("tow");
        assertTrue(hashTable1.equals(hashTable));
    }
    @Test
    public void testEqualsReflexive(){
        HashTable hashTable = new HashTable();
        hashTable.put("one");
        hashTable.put("tow");
        assertTrue(hashTable.equals(hashTable));
    }
    @Test
    public void testEqualsNull(){
        HashTable hashTable = new HashTable();
        hashTable.put("one");
        hashTable.put("tow");
        assertFalse(hashTable.equals(null));
    }

    @Test
    public void testEqualsNotHashTable(){
        HashTable hashTable = new HashTable();
        LinkedList<String> list = new LinkedList<>();
        list.insert("one");
        list.insert("tow");
        hashTable.put("one");
        hashTable.put("tow");
        assertFalse(hashTable.equals(list));
    }
}
