package com.egtinteractive.binarytree;

public interface Tree<T> extends Iterable<T> {
    void add(T element); // adds the specified element to the tree;
    boolean remove(T element); // removes the specified element from this tree if it is present;
    T lower(T e); // returns the greatest element in this set strictly less than the given element, or null if there is no such element;
    T higher(T e); // returns the least element in this set strictly greater than the given element, or null if there is no such element;
    T pollFirst(); // retrieves and removes the first (lowest) element or returns null if this tree is empty;
    T pollLast(); // retrieves and removes the last (highest) element or returns null if this tree is empty
    boolean contains(T o); // returns true if this tree contains the specified element;
    int size(); // returns the number of the elements in this tree;
    void clear(); // removes all of the elements from this tree;
    java.util.Iterator<T> iterator(); // returns an iterator over the elements;
    boolean equals(Object otherObject); // indicates whether some other object is "equal to" this one;
    int hashCode(); // returns a hash code value for the object;
}
