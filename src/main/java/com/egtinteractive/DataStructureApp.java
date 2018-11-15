package com.egtinteractive;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericList;
import com.egtinteractive.map.GenericMap;
import com.egtinteractive.map.Map;
import com.egtinteractive.map.MapEntry;

public class DataStructureApp {

    public static void main(String[] args) {

	Map<Integer, String> map = new GenericMap<>();
	GenericList<Integer> list = new GenericArrayList<>();
	
	list.add(1);
	list.add(2);
	list.add(1);
	list.add(2);
	list.add(1);
	list.add(2);
	list.add(1);
	list.add(2);
	list.add(1);
	list.add(2);
	list.set(9, 10);
	
	System.out.println(list.size());
	System.out.println();
	for (Integer integer : list) {
	    System.out.println(integer);
	    
	}
//	System.out.println();
//	System.out.println(list.hashCode());
//	System.out.println(list.hashCode());
//	list.add(30);
//	System.out.println(list.hashCode());

	
    }
}
