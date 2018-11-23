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

public class LowerTest extends Generator {

    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void lower_shouldReturnLowerElement_ifExist() {
	// Arrange
	int node = 38;

	// Act
	int lower = tree.lower(node);

	// Assert
	assertEquals(37, lower);
    }
    
    @Test
    public void lower_shouldReturnNull_ifNoSuchElement() {
	// Arrange
	int node = 10;

	// Assert
	assertNull(tree.lower(node));
    }
}
