package org.example;

import org.example.exceptions.BadIndexException;
import org.example.exceptions.BadParamException;
import org.example.exceptions.BadSizeException;
import org.example.exceptions.NotFoundException;

public interface StringList {

    String add(String item) throws BadSizeException, BadParamException;


    String add(int index, String item) throws BadSizeException, BadParamException, BadIndexException;


    String set(int index, String item) throws BadIndexException, BadParamException;

    String remove(String item) throws BadParamException, NotFoundException, BadIndexException;

    String remove(int index) throws NotFoundException, BadIndexException;

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index) throws BadIndexException;

    boolean equals(StringList otherList);

    int size();

    boolean isEmpty();

    void clear();

    String[] toArray();
}
