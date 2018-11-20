package com.egtinteractive;

import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

public class DataStructureApp {

    public static void main(String[] args) {

	Tree<Integer> tree = new BinaryTree<>();
	tree.add(6);
	tree.add(4);
	tree.add(8);
	tree.add(3);
	tree.add(5);
	tree.add(7);
	tree.add(9);
	
	tree.remove(4);

	
	System.out.println();
	System.out.println(tree.size());
	System.out.println();
	
	System.out.println(tree.contains(9));
    }
}
