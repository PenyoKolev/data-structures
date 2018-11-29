package com.egtinteractive.list;

import java.util.Iterator;
import java.util.Objects;

public class GenericLinkedList<T> implements GenericList<T> {

    private static class Node<T> {

	private T data;
	private Node<T> next;

	public Node(T data, Node<T> next) {
	    this.data = data;
	    this.next = next;
	}

	public Node(T data) {
	    this(data, null);
	}
    }

    private Node<T> head;
    private int size = 0;

    public GenericLinkedList() {
    }

    @Override
    public T get(int index) {
	indexValidation(index);
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
	if (index == size) {
	    add(element);
	    return;
	}
	indexValidation(index);
	if (index == 0) {
	    Node<T> current = head;
	    Node<T> newNode = new Node<T>(element, current);
	    head = newNode;
	    newNode.next = current;
	    size++;
	    return;
	}
	Node<T> current = nodeAt(index - 1);
	current.next = new Node<T>(element, current.next);
	size++;
    }

    @Override
    public void set(int index, T element) {
	indexValidation(index);
	Node<T> current = nodeAt(index);
	current.data = element;
    }

    @Override
    public boolean remove(T element) { // Check (integer could be value or index)
	int index = indexOf(element);
	if (head == null || index == -1) {
	    return false;
	}
	return remove(index);
    }

    @Override
    public boolean remove(int index) {
	indexValidation(index);
	if (index == 0) {
	    head = head.next;
	} else {
	    Node<T> previousNode = nodeAt(index - 1);
	    Node<T> nodeToRemove = previousNode.next;
	    previousNode.next = nodeToRemove.next;
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
	if (size != 0) {
	    Node<T> current = head;
	    for (int index = 0; index < size; index++) {
		if (Objects.equals(current.data, element)) {
		    return index;
		}
		current = current.next;
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
	size = 0;
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
	if (!(otherObject instanceof GenericList)) {
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
	Iterator<T> it = iterator();
	int result = 17;

	while (it.hasNext()) {
	    result = 31 * result + Objects.hashCode(it.next());
	}
	return result + Objects.hashCode(size);
    }

    // Helpers

    private class MyIterator implements Iterator<T> {
	Node<T> current = head;
	Node<T> previous = null;
	boolean canRemove = false;

	@Override
	public boolean hasNext() {
	    return current != null;
	}

	@Override
	public T next() {
	    previous = current;
	    current = current.next;
	    return previous.data;
	}

	@Override
	public void remove() {
	    if (canRemove) {
		previous.next = current.next;
		canRemove = false;
	    }
		size--;
	}
    }

    private Node<T> nodeAt(int index) {
	indexValidation(index);
	Node<T> current = head;
	for (int i = 0; i < index; i++) {
	    current = current.next;
	}
	return current;
    }

    private void indexValidation(int index) {
	if (index < 0 || index > size - 1) {
	    String message = String.format("\nIndex: %d out of bound!\nShould be in a range of 0 to %d", index,
		    size - 1);
	    throw new IndexOutOfBoundsException(message);
	}
    }
}
