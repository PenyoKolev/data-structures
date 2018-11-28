package com.egtinteractive;

import java.util.Iterator;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;
import com.egtinteractive.map.GenericMap;
import com.egtinteractive.map.Map;

public class DataStructureApp {

    public static void main(String[] args) {

	Map<Integer, String> map = new GenericMap<>();
	Map<Integer, String> map1 = new GenericMap<>();

	map.put(1, "one");
	map.put(2, "two");
	map.put(3, "three");
	map.put(4, "four");
	map.put(5, "five");
	
	map1.put(1, "one");
	map1.put(2, "two");
	map1.put(3, "three");
	map1.put(4, "four");
	map1.put(5, "five");
	
	map.remove(1);

	System.out.println(map.equals(map1));
    }
}
