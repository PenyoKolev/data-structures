package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;

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

public class SizeTest extends Generator {

    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void add_shouldReturnSize() {
	//Arrange
	int realSize = 12;
	
	// Act
	int size = tree.size();

	// Assert
	assertEquals(realSize, size);
    }
}
