package com.egtinteractive;

import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;;

public class DataStructureApp {

    public static void main(String[] args) {

	Tree<Integer> tree = new BinaryTree<>();
	int[] numbers = {38, 13, 51, 10, 12, 40, 84, 25, 89, 37, 66, 95};
	for (int i : numbers) {
	    tree.add(i);
	}
	
	System.out.println();
	
	
	for (Integer i : numbers) {
	    System.out.println(i);
	}
    }
}
