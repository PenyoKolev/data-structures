package com.egtinteractive.map;

import java.util.Iterator;
import java.util.Objects;

public class GenericMap<K, V> implements Map<K, V> {

    private Node<K, V>[] entries;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    static class Node<K, V> {

	private K key;
	private V value;
	private Node<K, V> next;

	public Node(K key, V value, Node<K, V> next) {
	    this.key = key;
	    this.value = value;
	    this.next = next;
	}

	public V getValue() {
	    return value;
	}

	public void setValue(V value) {
	    this.value = value;
	}

	public Node<K, V> getNext() {
	    return next;
	}

	public void setNext(Node<K, V> next) {
	    this.next = next;
	}

	public K getKey() {
	    return key;
	}
    }

    @SuppressWarnings("unchecked")
    public GenericMap() {
	entries = new Node[INITIAL_CAPACITY];
    }

    @Override
    public V get(K key) {
	int index = hash(key, entries.length);
	if (entries[index] == null) {
	    return null;
	} else {
	    Node<K, V> temp = entries[index];
	    while (temp != null) {
		if (temp.getKey().equals(key)) {
		    return temp.getValue();
		}
		temp = temp.getNext();
	    }
	}
	return null;
    }

    @Override
    public V put(K key, V value) {
	if (size >= entries.length) {
	    resize();
	}
	int index = hash(key, entries.length);
	Node<K, V> newEntry = new Node<K, V>(key, value, null);
	if (entries[index] == null) {
	    entries[index] = newEntry;
	} else {
	    Node<K, V> previous = null;
	    Node<K, V> current = entries[index];

	    while (current != null) {
		if (current.getKey().equals(key)) {
		    if (previous == null) {
			newEntry.setNext(current.getNext());
			entries[index] = newEntry;
			return value;
		    } else {
			newEntry.setNext(current.getNext());
			previous.setNext(newEntry);
			return value;
		    }
		}
		previous = current;
		current = current.getNext();
	    }
	    previous.setNext(newEntry);
	}
	size++;
	return value;
    }

    @Override
    public V remove(K key) {
	if (key == null) {
	    return null;
	}
	int index = hash(key, entries.length);
	Node<K, V> temp = entries[index];
	if (temp != null && temp.getKey().equals(key)) {
	    entries[index] = null;
	    size--;
	    return temp.getValue();
	}
	return null;
    }

    @Override
    public boolean containsKey(K key) {
	int index = hash(key, entries.length);
	Node<K, V> temp = entries[index];
	while (temp != null) {
	    if (temp.getKey().equals(key)) {
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    @Override
    public boolean containsValue(V value) {
	for (Node<K, V> entry : entries) {
	    if (entry != null && entry.getValue().equals(value)) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public int size() {
	return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
	entries = new Node[INITIAL_CAPACITY];
	size = 0;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
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
	if (!(otherObject instanceof Map)) {
	    return false;
	}

	@SuppressWarnings("unchecked")
	Map<K, V> newMap = (Map<K, V>) otherObject;
	if (size != newMap.size()) {
	    return false;
	}

	Iterator<Node<K, V>> it = iterator();

	while (it.hasNext()) {
	    Node<K, V> current = it.next();
	    if (!newMap.containsKey(current.getKey())) {
		return false;
	    }
	    if (!current.getValue().equals(newMap.get(current.getKey()))) {
		return false;
	    }
	}

	return true;
    }

    @Override
    public int hashCode() {
	Iterator<Node<K, V>> it = iterator();
	int result = 17;

	while (it.hasNext()) {
	    Node<K, V> mapEntry = it.next();
	    K nextKey = mapEntry.getKey();
	    V nextValue = mapEntry.getValue();

	    int hashKey = mapEntry.getKey() == null ? 0 : Objects.hashCode(nextKey);
	    int hashValue = mapEntry.getValue() == null ? 0 : Objects.hashCode(nextValue);

	    result = 31 * result + (hashKey + hashValue);
	}
	return result;
    }

    // Helpers

    private class MyIterator implements Iterator<Node<K, V>> {
	private int index;
	private Node<K, V> marker = entries[index];
	private Node<K, V> current = null;

	@Override
	public boolean hasNext() {
	    while (index < entries.length && marker == null) {
		marker = entries[index];
		if (marker == null) {
		    index++;
		}
	    }
	    if (index < entries.length) {
		return true;
	    }
	    return false;
	}

	@Override
	public Node<K, V> next() {
	    if (hasNext()) {
		current = marker;
		marker = marker.getNext();
		if (marker == null) {
		    index++;
		}
		return current;

	    }
	    return null;
	}

	@Override
	public void remove() {
	    if (current != null) {
		GenericMap.this.remove(current.getKey());
	    }
	}

    }

    @SuppressWarnings("unchecked")
    private void resize() {
	Node<K, V>[] temp = entries;
	entries = new Node[size * 2];

	for (Node<K, V> entry : temp) {
	    while (entry != null) {
		put(entry.getKey(), entry.getValue());
		entry = entry.getNext();
		size--;
	    }
	}
    }

    private int hash(K key, int size) {
	return Math.abs(key.hashCode()) % size;
    }

}
