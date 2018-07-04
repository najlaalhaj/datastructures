package com.datastructure;

import java.util.Arrays;

public class HashTable{
    private LinkedList[] hashArray;
    private static final int size = 10;

    public HashTable() {
        this.hashArray = new LinkedList[size];
        for(int i=0;i<size;i++) {
            hashArray[i] = new LinkedList();
        }
    }

    private int hashKey(String key){
        int hash =0;
        for(int i=0;i<key.length();i++) {
            hash += key.charAt(i);
        }
        return hash%size;
    }
    public boolean contains(String key){
        int hash = hashKey(key);
        LinkedList list = hashArray[hash];
        return list.contains(key);
    }

    public boolean put(String key){
        int hash= hashKey(key);
        LinkedList list;
        list = hashArray[hash];
        if(!list.contains(key)) {
            list.insertFirst(key);
            return true;
        }
        return false;
    }

    public boolean remove(String key){
        int hash = hashKey(key);
        LinkedList list = hashArray[hash];
        if(list.contains(key)) {
            list.remove(key);
            return true;
        }
        return  false;
        }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(o==null) return false;
        if(!(o instanceof HashTable)) return false;
        if(hashArray.length != ((HashTable) o).hashArray.length) return false;
            for (int i = 0; i < hashArray.length; i++) {
                if (!hashArray[i].equals(((HashTable) o).hashArray[i])) {
                    return false;
                }
            }
            return true;
    }

}

