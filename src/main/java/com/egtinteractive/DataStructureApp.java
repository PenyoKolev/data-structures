package com.egtinteractive;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

//	GenericList<Integer> list = new GenericLinkedList<>();
//	list.add(1);
//	list.add(2);
//	list.add(3);
//	list.add(4);
//	list.add(5);
//	list.add(null);
//	
//
//	for (Integer integer : list) {
//	    System.out.println(integer);
//	}
//	
//	
//	System.out.println(list.contains(null));
	
	GenericList<Integer> list = new GenericArrayList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list.add(6);
	list.add(7);
	list.add(8);
	list.add(9);
	//list.add(10);
	

	for (Integer integer : list) {
	    System.out.println(integer);
	}
	
	System.out.println(list.get(8));
    }
}
