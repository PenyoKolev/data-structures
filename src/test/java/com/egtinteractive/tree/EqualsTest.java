package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeMethod;

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

public class EqualsTest extends Generator {

    Tree<Integer> tree;
    Tree<Integer> tree1;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	tree1 = new BinaryTree<>();
	fillTreeWithIntegers(tree);
	for (Integer integer : tree) {
	    tree1.add(integer);
	}
    }

    @Test
    public void equals_shouldReturnTrue_ifTreesAreEquals() {
	//Act
	boolean isEqual = tree.equals(tree1);
	
	//Assert
	assertTrue(isEqual);
    }
    
    @Test
    public void equals_shouldReturnFalse_ifTreesAreNotEquals() {
	//Arrange
	tree.add(ThreadLocalRandom.current().nextInt(100, 200));
	
	//Act
	boolean isEqual = tree.equals(tree1);
	
	//Assert
	assertFalse(isEqual);
    }
}
