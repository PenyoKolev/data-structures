package com.egtinteractive.map;

import java.util.Iterator;
import java.util.Objects;

public class GenericMap<K, V> implements Map<K, V> {

    private MapEntry<K, V>[] entries;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public GenericMap() {
	clear();
    }

    @Override
    public V get(K key) {
	int index = hash(key);
	if (entries[index] == null) {
	    return null;
	} else {
	    MapEntry<K, V> temp = entries[index];
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
	int index = hash(key);
	MapEntry<K, V> newEntry = new MapEntry<K, V>(key, value, null);
	if (entries[index] == null) {
	    entries[index] = newEntry;
	} else {
	    MapEntry<K, V> previous = null;
	    MapEntry<K, V> current = entries[index];

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
	int index = hash(key);
	MapEntry<K, V> temp = entries[index];
	if (temp != null && temp.getKey().equals(key)) {
	    entries[index] = null;
	    size--;
	    return temp.getValue();
	}
	return null;
    }

    @Override
    public boolean containsKey(K key) {
	int index = hash(key);
	MapEntry<K, V> temp = entries[index];
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
	for (MapEntry<K, V> entry : entries) {
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
	entries = new MapEntry[INITIAL_CAPACITY];
	size = 0;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
	Iterator<MapEntry<K, V>> iterator = new Iterator<MapEntry<K, V>>() {
	    private int index;
	    private MapEntry<K, V> marker = entries[index];
	    private MapEntry<K, V> current = null;

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
	    public MapEntry<K, V> next() {
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
	};
	return iterator;
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

	@SuppressWarnings("unchecked")
	Map<K, V> newMap = (Map<K, V>) otherObject;

	Iterator<MapEntry<K, V>> it = iterator();

	while (it.hasNext()) {
	    MapEntry<K, V> current = it.next();
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
	Iterator<MapEntry<K, V>> it = iterator();
	int result = 17;

	while (it.hasNext()) {
	    MapEntry<K, V> mapEntry = it.next();
	    K nextKey = mapEntry.getKey();
	    V nextValue = mapEntry.getValue();

	    int hashKey = mapEntry.getKey() == null? 0 : Objects.hashCode(nextKey);  
	    int hashValue = mapEntry.getValue() == null? 0 : Objects.hashCode(nextValue); 

	    result = 31 * result + (hashKey + hashValue);
	}
	return result;
    }

    // Helpers

    @SuppressWarnings("unchecked")
    private void resize() {
	MapEntry<K, V>[] temp = new MapEntry[entries.length * 2];
	System.arraycopy(entries, 0, temp, 0, entries.length);
	entries = temp;
    }

    private int hash(K key) {
	return Math.abs(key.hashCode()) % entries.length;
    }

}
