package com.egtinteractive;

import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericLinkedList<>();
	list.add(1);
	list.add(2);
	GenericList<Integer> list1 = new GenericLinkedList<>();
	list1.add(1);
	list1.add(2);
	list.set(0, 5);
	
	System.out.println(list.equals(list1));
    }
}
