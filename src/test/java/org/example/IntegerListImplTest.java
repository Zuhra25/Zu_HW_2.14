package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntegerListImplTest {
    IntegerListImpl integerList = new IntegerListImpl();
    Integer number = 55;

    @Test
    public void addByItem() {
        Integer expect = integerList.add(55);
        assertEquals(number, expect);
    }

    @Test
    public void addByIndex() {
        Integer result = integerList.add(0, 55);
        assertEquals(number, result);
    }

    @Test
    public void setByIndexAndItem() {
        Integer expect = integerList.set(0, 55);
        assertEquals(number, expect);
    }

    @Test
    public void removeByItem() {
        addByItem();
        Integer result = integerList.remove(0);
        for (Integer i : integerList.toArray()) {
            if (i != result) ;
        }
    }

    @Test
    public void removeByIndex() {
        addByItem();
        Integer result = integerList.remove(0);
        for (Integer i : integerList.toArray()) {
            if (i != result) ;
        }
    }

    @Test
    public void containsItem() {
        Integer result = integerList.add(0, 55);
        result.equals(integerList.get(0));
    }

    @Test
    public void indexOf() {
        addByItem();
        int result = 0;
        assertEquals(result, integerList.indexOf(55));
    }

    @Test
    public void get() {
        addByIndex();
        assertEquals(number, integerList.get(0));
    }

    @Test
    public void testEquals() {
        Integer result = integerList.add(55);
        Integer expect = integerList.add(0, 55);
        assertEquals(expect, result);
    }

    @Test
    public void size() {
        addByItem();
        assertEquals(1, integerList.size());
    }

    @org.junit.Test
    public void isEmpty() {
        assertEquals(true, integerList.isEmpty());
    }

    @org.junit.Test
    public void clear() {
        addByItem();
        integerList.clear();
        isEmpty();
    }

}
