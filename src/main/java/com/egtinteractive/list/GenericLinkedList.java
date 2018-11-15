package com.egtinteractive.list;

import java.util.Iterator;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class GenericLinkedList<T> implements GenericList<T> {

    private Node<T> head;
    private int size = 0;

    public GenericLinkedList() {
    }

    @Override
    public T get(int index) { 
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	Node<T> current = nodeAt(index);
	return current.data;
    }

    @Override
    public void add(T data) { 
	if (head == null) {
	    head = new Node<T>(data);
	} else {
	    Node<T> current = head;
	    while (current.next != null) {
		current = current.next;
	    }
	    current.next = new Node<T>(data);
	}
	size++;
    }

    @Override
    public void add(int index, T element) { 
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	Node<T> current = nodeAt(index - 1);
	current.next = new Node<T>(element, current.next);
	size++;
    }

    @Override
    public void set(int index, T element) { 
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	Node<T> current = nodeAt(index);
	current.data = element;
    }

    @Override
    public boolean remove(T element) { 
	int index = indexOf(element);
	if (head == null || index == -1) {
	    return false;
	}
	return remove(index);
    }

    @Override
    public boolean remove(int index) { 
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0) {
	    head = head.next;
	} else {
	    Node<T> previousNode = nodeAt(index - 1);
	    Node<T> nodeToRemove = previousNode.getNext();
	    previousNode.setNext(nodeToRemove.getNext());
	}
	size--;
	return true;
    }

    @Override
    public boolean contains(T o) { 
	return indexOf(o) != -1;
    }

    @Override
    public int indexOf(T element) { 
	if (head != null) {
	    Node<T> current = head;
	    for (int index = 0; index < size; index++) {
		if (current.data.equals(element)) {
		    return index;
		}
		current = current.getNext();
	    }
	}
	return -1;
    }

    @Override
    public int size() { 
	return size;
    }

    @Override
    public void clear() { 
	head = null;
    }

    @Override
    public Iterator<T> iterator() { 
	return new MyIterator();
    }

    @Override
    public boolean equals(Object otherObject) { 
	if (this == otherObject) {
	    return true;
	}
	if (otherObject == null) {
	    return false;
	}
	if (getClass() != otherObject.getClass()) {
	    return false;
	}
	GenericList<?> list = (GenericList<?>) otherObject;
	if (size != list.size()) {
	    return false;
	}
	Iterator<T> it1 = iterator();
	Iterator<?> it2 = list.iterator();

	while (--size >= 0) {
	    if (!it1.next().equals(it2.next())) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public int hashCode() { 
	HashCodeBuilder hcb = new HashCodeBuilder();
	Iterator<T> it = iterator();

	while (it.hasNext()) {
	    hcb.append(it.next());
	}
	return hcb.toHashCode();
    }

    // Helpers
    private class MyIterator implements Iterator<T> { 
	Node<T> current = head;

	@Override
	public boolean hasNext() {
	    return current != null;
	}
	
	@Override
	public T next() {
	    T element = current.data;
	    current = current.next;
	    return element;
	}
    }
    
    private Node<T> nodeAt(int index) {
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	Node<T> current = head;
	for (int i = 0; i < index; i++) {
	    current = current.next;
	}
	return current;
    }

    private boolean isNotValid(int index) {
	return index < 0 || index > size - 1 ? true : false;
    }
}
