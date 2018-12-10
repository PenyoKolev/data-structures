package com.egtinteractive;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<String> list = new GenericArrayList<>();
	list.add("one");
	list.add("two");
	list.add("three");
	list.add("four");
	
	System.out.println(list.remove(1));
	System.out.println(list.size());
	
	for (String string : list) {
	    System.out.println(string);
	}
	
    }
}
