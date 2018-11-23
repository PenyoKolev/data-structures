package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
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

public class PollLastTest extends Generator {

    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void pollLast_shouldReturnGreatestElement() {
	// Act
	int greatest = tree.pollLast();

	// Assert
	assertEquals(greatest, 95);
    }

    @Test
    public void pollLast_shouldDeleteGreatestElement() {
	// Arrange
	int greatest = 95;

	// Act
	tree.pollLast();

	// Assert
	assertFalse(tree.contains(greatest));
    }

    @Test
    public void pollLast_shouldReturnNull_ifTreeIsEmpty() {
	// Arrange
	tree.clear();

	// Assert
	assertNull(tree.pollLast());
    }

    @Test
    public void pollLast_shouldDecreaseSize() {
	// Arrange
	int size = tree.size();

	// Act
	tree.pollLast();

	// Assert
	assertNotEquals(tree.size(), size);
    }
}
