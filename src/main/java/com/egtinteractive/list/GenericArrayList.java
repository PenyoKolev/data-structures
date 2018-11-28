package com.egtinteractive.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.IntStream;

public class GenericArrayList<T> implements GenericList<T> {

    private static final int INITIAL_CAPACITY = 10;
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public GenericArrayList() {
	array = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public T get(int index) {
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException(message(index));
	}
	return array[index];
    }

    @Override
    public void add(T element) {
	if (size >= array.length) {
	    resize();
	}
	array[size] = element;
	size++;
    }

    @Override
    public void add(int index, T element) {
	if (index == size) {
	    add(element);
	    return;
	}
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException(message(index));
	}
	size++;
	if (size >= array.length) {
	    resize();
	}
	for (int i = size - 1; i >= index; i--) {
	    if (i != 0) {

	    }
	    array[i + 1] = array[i];
	}
	array[index] = element;
    }

    @Override
    public void set(int index, T element) {
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException(message(index));
	}
	array[index] = element;
    }

    @Override
    public boolean remove(T element) {   // Check with Ivailo(if list of integers no difference entre element and index)
	int index = indexOf(element);
	if (index == -1) {
	    return false;
	}
	return remove(index);
    }

    @Override
    public boolean remove(int index) {    // Check with Ivailo
	if (isNotValid(index)) {
	    for (int i = 0; i < size; i++) {
		if (index == (int) array[i]) {
		    return remove(i);
		}
	    }
	    return false;
	}
	System.arraycopy(array, index + 1, array, index, size - index - 1);
	size--;
	return true;
    }

    @Override
    public boolean contains(T o) {
	return indexOf(o) != -1;
    }

    @Override
    public int indexOf(T element) {
	int index = IntStream.range(0, array.length)
		.filter(i -> element.equals(array[i]))
		.findFirst()
		.orElse(-1);
	return index;
    }

    @Override
    public int size() {
	return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
	array = (T[]) new Object[INITIAL_CAPACITY];
	size = 0;
    }

    @Override
    public Iterator<T> iterator() {
	return new ListIterator();
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

	while (it1.hasNext()) {
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
	
	while(it.hasNext()) {
	    result = 31 * result + Objects.hashCode(it.next());
	}
	return result + Objects.hashCode(size);
    }

    // Helpers
    private class ListIterator implements Iterator<T> {
	private int current = 0;

	@Override
	public boolean hasNext() {
	    return current < size;
	}

	@Override
	public T next() {
	    if (hasNext()) {
		return array[current++];
	    } else {
		throw new NoSuchElementException("No next element!");
	    }
	}
	
	@Override
	public void remove() {
	    if (isNotValid(current)) {
		GenericArrayList.this.remove(current);
		current--;
	    }
	}
    }

    @SuppressWarnings("unchecked")
    private void resize() {
	T[] newArray = (T[]) new Object[array.length * 2];
	System.arraycopy(array, 0, newArray, 0, array.length);
	array = newArray;
    }

    private boolean isNotValid(int index) {
	return index < 0 || index > size - 1;
    }
    
    private String message(int index) {
	return String.format("\nIndex: %d out of bound!\nShould be in a range of 0 to %d", index, size - 1);
    }
}
