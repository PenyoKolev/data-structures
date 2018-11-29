package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

/**		       	Tree example:	
 *				
 *				38
 *			       /  \
 *			      /	   \
 *			     /	    \
 *			    13	    51
 *			   /  \    /  \	
 *			  10  25  40  84
 *			    \   \    /  \
 *			    12  37  66  89
 *					  \
 *					  95
 */

@Test(groups = "tree-tests")
public class EqualsTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>(), new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void equalsShouldReturnTrueIfTreesAreEquals(BinaryTree<Integer> tree, BinaryTree<Integer> tree1) {
	//Arrange
	fillTreeWithIntegers(tree);
	for (Integer integer : tree) {
	    tree1.add(integer);
	}

	//Act
	boolean isEqual = tree.equals(tree1);
	
	//Assert
	assertTrue(isEqual);
    }
    
    @Test(dataProvider = "trees")
    public void equalsShouldReturnFalseIfTreesAreNotEquals(BinaryTree<Integer> tree, BinaryTree<Integer> tree1) {
	//Arrange
	fillTreeWithIntegers(tree);
	for (Integer integer : tree) {
	    tree1.add(integer);
	}
	tree.add(ThreadLocalRandom.current().nextInt(100, 200));
	
	//Act
	boolean isEqual = tree.equals(tree1);
	
	//Assert
	assertFalse(isEqual);
    }
}
