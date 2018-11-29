package com.egtinteractive;

import java.util.ArrayList;
import java.util.List;

public class DataStructureApp {

    public static void main(String[] args) {

	List<Integer> list = new ArrayList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	
//	list.remove(0);

	for (Integer integer : list) {
	    System.out.println(integer);
	}
    
    }
}
