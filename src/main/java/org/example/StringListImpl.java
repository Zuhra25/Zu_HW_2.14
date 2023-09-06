package org.example;

import org.example.exceptions.BadIndexException;
import org.example.exceptions.BadParamException;
import org.example.exceptions.BadSizeException;
import org.example.exceptions.NotFoundException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] arrayStrings;
    private int size;

    public StringListImpl() {
        arrayStrings = new String[10];
    }

    public StringListImpl(int arraySize) {
        arrayStrings = new String[arraySize];
    }

    @Override
    public String add(String item) {
        sizeCheck();
        nullCheck(item);
        arrayStrings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        sizeCheck();
        nullCheck(item);
        indexCheck(index);
        if (index == size) {
            arrayStrings[size++] = item;
            return item;
        }
        System.arraycopy(arrayStrings, index, arrayStrings, index + 1, size - index);
        arrayStrings[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        indexCheck(index);
        nullCheck(item);
        arrayStrings[index] = item;
        return item;
    }

    @Override
    public String remove(String item)  {
        nullCheck(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index)  {
        indexCheck(index);
        if (index == -1) {
            throw new NotFoundException();
        }
        if (index != size) {
            System.arraycopy(arrayStrings, index + 1, arrayStrings, index, size - index);
        }
        size--;
        return arrayStrings[index];
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrayStrings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size; i < 0; i--) {
            if (arrayStrings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index)  {
        indexCheck(index);
        return arrayStrings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayStrings, size);
    }


    private void nullCheck(String item)  {
        if (item == null) {
            throw new BadParamException();
        }
    }

    private void sizeCheck()  {
        if (size > arrayStrings.length) {
            throw new BadSizeException();
        }
    }

    private void indexCheck(int index)  {
        if (index < 0 || index >= arrayStrings.length) {
            throw new BadIndexException();
        }
    }
}
