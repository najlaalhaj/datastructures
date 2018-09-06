package com.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {
    @Test
    public void testEmptyTree(){
        BinarySearchTree emptyTree = new BinarySearchTree();
        assertEquals(null,emptyTree.get(6));
    }

    @Test
    public void testNonExistedKey(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(7));
        assertEquals(null,tree.get(8));
    }

    @Test
    public void testInsert(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(7));
    }

    @Test
    public void testGetAll(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(7));
    }
}
