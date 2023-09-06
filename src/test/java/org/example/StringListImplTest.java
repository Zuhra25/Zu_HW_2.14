package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringListImplTest {

    StringListImpl stringList = new StringListImpl(10);

    @Test
    public void addByItem() {
        String expect = stringList.add("text");
        assertEquals("text", expect);
    }

    @Test
    public void addByIndex() {
        String result = stringList.add(0, "text");
        assertEquals("text", result);
    }

    @Test
    public void setByIndexAndItem() {
        String expect = stringList.set(0, "text");
        assertEquals("text", expect);
    }

    @Test
    public void removeByItem() {
        addByItem();
        String result = stringList.remove("text");
        for (String i : stringList.toArray()) {
            if (i != result) ;
        }
    }

    @Test
    public void removeByIndex() {
        addByItem();
        String result = stringList.remove(0);
        for (String i : stringList.toArray()) {
            if (i != result) ;
        }
    }

    @Test
    public void contains() {
        String result = stringList.add(0, "text");
        result.contains(stringList.get(0));

    }

    @Test
    public void indexOf() {
        addByItem();
        int result = 0;
        assertEquals(result, stringList.indexOf("text"));
    }

    @Test
    public void lastIndexOf() {
        addByItem();
        int result = -1;
        assertEquals(result, stringList.indexOf("not true text"));
    }

    @Test
    public void get() {
        addByIndex();
        assertEquals("text", stringList.get(0));
    }

    @Test
    public void testEquals() {
        String result = stringList.add("text");
        String expect = stringList.add(0, "text");
        assertEquals(expect, result);
    }

    @Test
    public void size() {
        addByItem();
        assertEquals(1, stringList.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(true, stringList.isEmpty());
    }

    @Test
    public void clear() {
        addByItem();
        stringList.clear();
        isEmpty();
    }

}
