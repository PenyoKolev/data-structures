package com.egtinteractive;

import java.util.ArrayList;
import java.util.List;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;
import com.egtinteractive.map.GenericMap;
import com.egtinteractive.map.GenericMap.Node;
import com.egtinteractive.map.Map;

public class DataStructureApp {

    public static void main(String[] args) {

	Map<Integer, String> map = new GenericMap<Integer, String>();
	Map<Integer, String> map1 = new GenericMap<Integer, String>();

	map.put(1, "one");
	map.put(2, "two");
	map.put(3, "three");
	map.put(4, "four");
	map.put(null, "KeyIsNull");
	map.put(7, null);
	
	map1.put(1, "one");
//	map1.put(2, "two");
	map1.put(3, "three");
	map1.put(4, "four");
	map1.put(null, "KeyIsNull");
	map1.put(7, null);
	
	System.out.println(map.equals(map1));
	
	System.out.println();
	for (Node<Integer, String> node : map) {
	    System.out.println(node.getKey() + " " + node.getValue());
	}
	
	
    }
}
