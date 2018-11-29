package com.egtinteractive;

import com.egtinteractive.map.GenericMap;
import com.egtinteractive.map.GenericMap.Node;
import com.egtinteractive.map.Map;

public class DataStructureApp {

    public static void main(String[] args) {

	Map<Integer, String> map = new GenericMap<>();
	map.put(1, "one");
	map.put(2, "two");
	map.put(3, "three");
	map.put(4, "four");
	map.put(5, "five");
	map.put(6, "one1");
	map.put(7, "two");
	map.put(8, "three");
	map.put(9, "four");
	map.put(10, "five");
	map.put(11, "one1");
	map.put(12, "two");
	map.put(13, "three");
	map.put(14, "four");
	map.put(15, "five");
	map.put(16, "one1");
	map.put(17, "two");
	map.put(18, "three");
	map.put(19, "four");
	map.put(20, "five");

	for (int i = 1; i <= map.size(); i++) {
		map.put(i, "new Value");
	}
	
	System.out.println(map.size());

	for (Node<Integer, String> node : map) {
	    System.out.println(node.getKey() + " " + node.getValue());
	}

	System.out.println(map.get(20));
    }
}
