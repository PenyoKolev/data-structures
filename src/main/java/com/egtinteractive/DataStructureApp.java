package com.egtinteractive;

import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

public class DataStructureApp {

    public static void main(String[] args) {

	int[] numbers = {38, 13, 51, 10, 12, 40, 84, 25, 89, 37, 66, 95};
	Tree<Integer> tree = new BinaryTree<>();

	for (Integer integer : numbers) {
	    tree.add(integer);
	}
	
	for (Integer integer : tree) {
	    System.out.println(integer);
	}
    }
}
