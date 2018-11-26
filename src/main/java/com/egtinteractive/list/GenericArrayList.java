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
	size = 0;
    }

    @Override
    public T get(int index) {
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
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

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, T element) {
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	T[] newArray = (T[]) new Object[size + 1];
	for (int i = 0; i < index; i++) {
	    newArray[i] = array[i];
	}
	newArray[index] = element;
	for (int i = index + 1; i < newArray.length; i++) {
	    newArray[i] = array[i - 1];
	}
	size++;
	array = newArray;
    }

    @Override
    public void set(int index, T element) {
	if (isNotValid(index)) {
	    throw new IndexOutOfBoundsException();
	}
	array[index] = element;
    }

    @Override
    public boolean remove(T element) {
	int index = indexOf(element);
	if (index == -1) {
	    return false;
	}
	return remove(index);
    }

    @Override
    public boolean remove(int index) {
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
	return indexOf(o) != -1 ? true : false;
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

    @Override
    public void clear() {
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
	return result;
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
		throw new NoSuchElementException();
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
	return index < 0 || index > size - 1 ? true : false;
    }
}
