package com.egtinteractive;

import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;
import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.list.GenericList;

public class DataStructureApp {

    public static void main(String[] args) {

	GenericList<Integer> list = new GenericLinkedList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(null);
	
	list.set(0, null);
	System.out.println(list.size());
	
	for (Integer integer : list) {
	    System.out.println(integer);
	}
    }
}
