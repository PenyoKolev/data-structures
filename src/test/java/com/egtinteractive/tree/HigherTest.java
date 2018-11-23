package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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

public class HigherTest extends Generator {
    
    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void higher_shouldReturnHigherElement_ifExist() {
	// Arrange
	int node = 38;

	// Act
	int lower = tree.higher(node);

	// Assert
	assertEquals(40, lower);
    }
    
    @Test
    public void higher_shouldReturnNull_ifNoSuchElement() {
	// Arrange
	int node = 95;

	// Assert
	assertNull(tree.higher(node));
    }
}
