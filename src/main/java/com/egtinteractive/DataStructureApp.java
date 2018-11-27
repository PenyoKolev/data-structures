package com.egtinteractive;

import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericLinkedList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list.add(5, 100);

	for (Integer integer : list) {
	    System.out.println(integer);
	}
	
	
	System.out.println(list.size());
    }
}
