package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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
public class LowerTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void lowerShouldReturnLowerElementIfExist(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int node = 38;

	// Act
	int lower = tree.lower(node);

	// Assert
	assertEquals(37, lower);
    }
    
    @Test(dataProvider = "trees")
    public void lowerShouldReturnNullIfNoSuchElement(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int node = 10;

	// Assert
	assertNull(tree.lower(node));
    }
}
