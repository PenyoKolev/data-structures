package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

public class IteratorTest extends Generator {
  
  Tree<Integer> tree;

  @BeforeMethod
  public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
  }
  
  @Test
  public void iterator_shouldIterateOverAllElements() {
      int size = tree.size();
	int iteration = 0;

	// Act
	for (Integer integer : tree) {
	    iteration++;
	}

	// Assert
	assertEquals(iteration, size);
  }
}
