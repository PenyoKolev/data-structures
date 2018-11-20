package com.egtinteractive;

import com.egtinteractive.map.GenericMap;
import com.egtinteractive.map.Map;
import com.egtinteractive.map.MapEntry;

public class DataStructureApp {

    public static void main(String[] args) {

	Map<String, Integer> map = new GenericMap<>();
	
	map.put("One", 111);
	map.put("Two", 222);
	map.put("Three", 333);
	map.put("Four", 444);
	map.put("Five", 555);
	map.put("Six", 666);
	map.put("Seven", 777);
	map.put("Eight", 888);
	map.put("Nine", 999);
	map.put("Ten", 1010);
//	map.put("Eleven", 1111);
	
	
	
	int i = 1;
	for (MapEntry<String, Integer> mapEntry : map) {
	    
	    System.out.println(mapEntry.getKey() + "   " + i++);
	}
	System.out.println(map.size());
	

	System.out.println(map.get("Ten"));
//	System.out.println();
//	for (MapEntry<?, ?> mapEntry : map) {
//	    System.out.println(mapEntry.getKey());
//	}
//
//	System.out.println(map.size());
//		System.out.println(map.get("Eight"));
//		System.out.println(map.size());
    }
}
