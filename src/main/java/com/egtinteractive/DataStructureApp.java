package com.egtinteractive;

import java.util.ArrayList;
import java.util.List;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericArrayList<>();	
	GenericList<Integer> list1 = new GenericArrayList<>();

	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list1.add(1);
	list1.add(2);
	list1.add(3);
	list1.add(4);
		
	System.out.println(list.equals(list1));
	
//	List<Integer> list = new ArrayList<>();
//	list.add(null);
//	
//	System.out.println(list.contains(null));
	
	for (Integer integer : list) {
	    System.out.println(integer);
	}
    }
}
