package com.egtinteractive.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
    public boolean remove(T element) {
	Pair<T> pair = indexAndPrevious(element);
	int index = pair.getIndex();
	if (head == null || index == -1) {
	    return false;
	}
	if (index == 0) {
	    head = head.next;
	} else {
	    removeNode(pair.getPrevious());
	}
	size--;
	return true;
    }

    @Override
    public boolean remove(int index) {
	indexValidation(index);
	if (index == 0) {
	    head = head.next;
	} else {
	    removeNode(nodeAt(index - 1));
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
	return indexAndPrevious(element).getIndex();
    }

    private static class Pair<T> {
	private int index;
	private Node<T> previous;

	public Pair(int index, Node<T> previous) {
	    this.setIndex(index);
	    this.setPrevious(previous);
	}

	public int getIndex() {
	    return index;
	}

	public void setIndex(int index) {
	    this.index = index;
	}

	public Node<T> getPrevious() {
	    return previous;
	}

	public void setPrevious(Node<T> previous) {
	    this.previous = previous;
	}
    }

    private Pair<T> indexAndPrevious(T element) {
	Node<T> previous = null;
	Node<T> current = head;
	Pair<T> pair = new Pair<T>(-1, previous);
	for (int index = 0; index < size; index++) {
	    if (Objects.equals(current.data, element)) {
		pair.index = index;
		pair.previous = previous;
		return pair;
	    }
	    previous = current;
	    current = current.next;
	}
	return pair;
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

	int index = size;
	while (--index >= 0) {
	    if (!Objects.equals(it1.next(), it2.next())) {
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
	Node<T> current = null;
	Node<T> previous = null;

	@Override
	public boolean hasNext() {
	    if (current == null) {
		return head != null;
	    } else
		return current.next != null;
	}

	@Override
	public T next() {
	    if (!hasNext()) {
		throw new NoSuchElementException("No such element");
	    }
	    previous = current;

	    if (current == null) {
		current = head;
	    } else {
		current = current.next;
	    }
	    return current.data;
	}

	@Override
	public void remove() {
	    if (previous == current)
		throw new IllegalStateException("Try to invoke next() and then remove()");
	    if (current == head) {
		GenericLinkedList.this.remove(head.data);
	    } else {
		GenericLinkedList.this.remove(previous.data);
	    }
	}
    }

    public void removeNode(Node<T> previous) {
	Node<T> nodeToRemove = previous.next;
	previous.next = nodeToRemove.next;
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
