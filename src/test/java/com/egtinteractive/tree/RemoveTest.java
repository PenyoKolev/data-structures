package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

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

public class RemoveTest extends Generator {

    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void remove_leafNode_shouldDeleteNode() {
	//Arrange
	int leaf = 12;
	//Act
	tree.remove(leaf);
	
	//Assert
	assertFalse(tree.contains(leaf));
    }
    
    @Test
    public void remove_nodeWithOneChild_shouldDeleteNode() {
	//Arrange
	int node = 10;
	int lower = tree.lower(12);  // 10
	
	//Act
	tree.remove(node);
	
	//Assert
	assertNull(tree.lower(12));
    }
    
    @Test
    public void remove_nodeWithTwoChild_shouldDeleteNode() {
	//Arrange
	int node = 38;
	
	//Act
	tree.remove(node);
	int lower = tree.lower(51);
	
	//Assert
	assertEquals(lower, 40);
    }
    
    @Test
    public void remove_shouldDecreaseSize() {
	// Arrange
	int random = ThreadLocalRandom.current().nextInt(0, 100);
	int size = tree.size();

	// Act
	tree.add(random);

	// Assert
	assertNotEquals(size, tree.size());
    }
}
