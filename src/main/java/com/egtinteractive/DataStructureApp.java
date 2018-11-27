package com.egtinteractive;

import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericArrayList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	System.out.println(list.size());
	System.out.println(list.hashCode());
    }
}
