package com.egtinteractive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {
	
	List<Integer> list = new LinkedList<>();
	list.add(1);
	list.add(2);
	list.add(10);
	
	System.out.println(list.remove(10));
    }
}
