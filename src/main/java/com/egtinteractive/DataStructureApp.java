package com.egtinteractive;

import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

public class DataStructureApp {

    public static void main(String[] args) {

	Tree<Integer> tree = new BinaryTree<>();
	Tree<Integer> tree1 = new BinaryTree<>();

	tree.add(20);
	tree.add(15);
	tree.add(25);
	tree.add(10);
	tree.add(18);
	tree.add(16);
	tree.add(17);
	

	System.out.println(tree.higher(10));

    }
}
