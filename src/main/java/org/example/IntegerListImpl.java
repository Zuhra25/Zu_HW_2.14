package org.example;

import org.example.exceptions.BadIndexException;
import org.example.exceptions.BadParamException;
import org.example.exceptions.BadSizeException;
import org.example.exceptions.NotFoundException;

import java.util.Arrays;
import java.util.List;


public class IntegerListImpl implements IntegerList {
    private final Integer[] arrayIntegers;
    private int size;

    public IntegerListImpl() {
        arrayIntegers = new Integer[10];
    }

    public IntegerListImpl(int arraySize) {
        arrayIntegers = new Integer[arraySize];
    }

    @Override
    public Integer add(Integer item) {
        sizeCheck();
        nullCheck(item);
        arrayIntegers[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        sizeCheck();
        nullCheck(item);
        indexCheck(index);
        if (index == size) {
            arrayIntegers[size++] = item;
            return item;
        }
        System.arraycopy(arrayIntegers, index, arrayIntegers, index + 1, size - index);
        arrayIntegers[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        indexCheck(index);
        nullCheck(item);
        arrayIntegers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        nullCheck(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        indexCheck(index);
        if (index == -1) {
            throw new NotFoundException();
        }
        if (index != size) {
            System.arraycopy(arrayIntegers, index + 1, arrayIntegers, index, size - index);
        }
        size--;
        return arrayIntegers[index];
    }

    @Override
    public boolean contains(Integer item) {
        List<Integer> listIntegers = List.of(toArray());
        sort(listIntegers);
        return binarySearch(listIntegers, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrayIntegers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size; i < 0; i--) {
            if (arrayIntegers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        indexCheck(index);
        return arrayIntegers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(arrayIntegers, size);
    }


    private void nullCheck(Integer item) {
        if (item == null) {
            throw new BadParamException();
        }
    }

    private void sizeCheck() {
        if (size > arrayIntegers.length) {
            throw new BadSizeException();
        }
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= arrayIntegers.length) {
            throw new BadIndexException();
        }
    }
    private void sort(List<Integer> list){
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1) >= temp) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, temp);
        }
    }
    private boolean binarySearch(List<Integer> list, Integer item){
        int min = 0;
        int max = list.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == list.get(mid)) {
                return true;
            }

            if (item < list.get(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
