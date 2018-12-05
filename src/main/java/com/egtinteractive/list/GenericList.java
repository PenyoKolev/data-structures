package com.egtinteractive.list;

public interface GenericList<T> extends Iterable<T> {

    T get(int index); // returns the element at the specified position;

    void add(T element); // appends the specified element to the end of this list;

    void add(int index, T element); // inserts the specified element at the specified position;

    void set(int index, T element); // overwrites the element at the specified position;

    boolean remove(T element); // removes the first occurrence of the specified element;

    boolean remove(int index); // removes the element at the specified position;

    boolean contains(T o); // returns true if this list contains the specified element;

    int indexOf(T element); // returns the index of the first occurrence of the specified element;

    int size(); // returns the number of elements in this list;

    void clear(); // removes all elements;
}
