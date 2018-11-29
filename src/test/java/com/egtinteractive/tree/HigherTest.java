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
public class HigherTest extends Generator {
    
    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void higherShouldReturnHigherElementIfExist(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int node = 38;

	// Act
	int lower = tree.higher(node);

	// Assert
	assertEquals(40, lower);
    }
    
    @Test(dataProvider = "trees")
    public void higherShouldReturnNullIfNoSuchElement(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int node = 95;

	// Assert
	assertNull(tree.higher(node));
    }
}
