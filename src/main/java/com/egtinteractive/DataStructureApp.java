package com.egtinteractive;

import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericLinkedList<>();
	
	list.add(1);
	list.add(2);
	
	System.out.println(list.size());
    }
}
