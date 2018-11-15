package com.egtinteractive.map;

public class MapEntry<K, V> {

    private K key;
    private V value;
    private MapEntry<K, V> next;
    
    public MapEntry(K key, V value, MapEntry<K, V> next) {
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
    public MapEntry<K, V> getNext() {
        return next;
    }
    public void setNext(MapEntry<K, V> next) {
        this.next = next;
    }
    public K getKey() {
        return key;
    }
}
