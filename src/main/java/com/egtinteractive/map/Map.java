package com.egtinteractive.map;

import java.util.Iterator;

import com.egtinteractive.map.GenericMap.Node;

public interface Map<K, V> extends Iterable<GenericMap.Node<K, V>> {

    V get(K key); // returns the value to which the specified key is mapped, or null if this map
		  // contains no mapping for the key;

    V put(K key, V value); // associates the specified value with the specified key in this map; returns
			   // the previous value, or null if there was no mapping for the key;

    V remove(K key); // removes the mapping for a key from this map if it is present; returns the
		     // previous value associated with the key;

    boolean containsKey(K key); // returns true if this map contains a mapping for the specified key;

    boolean containsValue(V value); // returns true if this map maps one or more keys to the specified value;

    int size(); // returns the number of key-value mappings in this map;

    void clear(); // removes all of the mappings from this map;

    Iterator<Node<K, V>> iterator();

}
