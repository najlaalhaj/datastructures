package com.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest<K,V> {
    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void containsValue() throws Exception {
        HashMap<String, Integer> table = new HashMap<>();
        assertTrue(table.put("one",1));
        assertTrue(table.containsValue("one"));
    }
    @Test
    public void testContainsNonExistingValue(){
        HashMap<String, Integer> table = new HashMap<>();
        table.put("one",1);
        assertTrue(table.containsValue("one"));
        assertFalse(table.containsValue("tow"));
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
        table.put("five",5);
        assertTrue(table.containsValue("one"));
        assertTrue(table.containsValue("four"));
        assertTrue(table.containsValue("five"));
    }

    @Test
    public void testPutCollision(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("tow",2);
        table.put("three",3);
        assertTrue(table.containsValue("one"));
        assertTrue(table.containsValue("tow"));
        assertTrue(table.containsValue("three"));
    }

    @Test
    public void testPutDuplicateKey(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        assertTrue(table.containsValue("one"));
        table.put("one",2);
        assertTrue(table.containsValue("one"));
        int value = (int)table.getValue("one");
        assertEquals(2,value);

    }


    @Test
    public void testRemoveCollisionFirst(){
        HashMap<Object,Integer> table= new HashMap<>();
        Object e1 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e2 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        table.put(e1,2);
        table.put(e2,3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        table.removeValue(e1);
        assertFalse(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
    }

    @Test
    public void testRemoveCollision(){
        HashMap<Object, Integer> table= new HashMap<>();
        Object e1 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e2 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e3 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        table.put(e1,1);
        table.put(e2,2);
        table.put(e3,3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        assertTrue(table.containsValue(e3));
        table.removeValue(e2);
        assertTrue(table.containsValue(e1));
        assertFalse(table.containsValue(e2));
        assertTrue(table.containsValue(e3));

    }

    @Test
    public void testRemoveCollisionLast(){
        HashMap<Object, Integer> table= new HashMap<>();
        Object e1 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e2 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e3 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        table.put(e1,1);
        table.put(e2,2);
        table.put(e3,3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        assertTrue(table.containsValue(e3));
        table.removeValue(e3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        assertFalse(table.containsValue(e3));
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
        table.removeValue("four");
        assertTrue(table.containsKey("one"));
        assertFalse(table.containsKey("four"));
        assertTrue(table.containsKey("five"));
    }
    @Test
    public void testGetValueCollisionFirst(){
        HashMap<Object, Integer> table= new HashMap<>();
        Object e1 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e2 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e3 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        table.put(e1,1);
        table.put(e2,2);
        table.put(e3,3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        assertTrue(table.containsValue(e3));
        int value= (int) table.getValue(e1);
        assertEquals(1,value);
    }

    @Test
    public void testGetValueCollision(){
        HashMap<Object, Integer> table= new HashMap<>();
        Object e1 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e2 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e3 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        table.put(e1,1);
        table.put(e2,2);
        table.put(e3,3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        assertTrue(table.containsValue(e3));
        int value= (int) table.getValue(e2);
        assertEquals(2,value);
    }

    @Test
    public void testGetValueCollisionLast(){
        HashMap<Object, Integer> table= new HashMap<>();
        Object e1 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e2 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        Object e3 = new Object(){
            public int hashCode(){
                return 82;
            }
        };
        table.put(e1,1);
        table.put(e2,2);
        table.put(e3,3);
        assertTrue(table.containsValue(e1));
        assertTrue(table.containsValue(e2));
        assertTrue(table.containsValue(e3));
        int value= (int) table.getValue(e3);
        assertEquals(3,value);
    }

    @Test
    public void testGetValue(){
        HashMap<String, Integer> table= new HashMap<>();
        table.put("one",1);
        table.put("four",4);
        table.put("five",5);
        assertTrue(table.containsValue("one"));
        assertTrue(table.containsValue("four"));
        assertTrue(table.containsValue("five"));
        int value= (int) table.getValue("four");
        assertEquals(4,value);
    }
}