package com.egtinteractive;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericArrayList<>(); 
	GenericList<Integer> list1 = new GenericArrayList<>(); 

	for (int i = 0; i < 10; i++) {
	    list.add(i);
	    list1.add(i);
	}
	
	list.set(0, 10);
	
	System.out.println(list.equals(list1));
    }
}
