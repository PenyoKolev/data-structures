package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
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
public class PollLastTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void pollLastShouldReturnGreatestElement(BinaryTree<Integer> tree) {
	// Act
	fillTreeWithIntegers(tree);
	int greatest = tree.pollLast();

	// Assert
	assertEquals(greatest, 95);
    }

    @Test(dataProvider = "trees")
    public void pollLastShouldDeleteGreatestElement(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int greatest = 95;

	// Act
	tree.pollLast();

	// Assert
	assertFalse(tree.contains(greatest));
    }

    @Test(dataProvider = "trees")
    public void pollLastShouldReturnNullIfTreeIsEmpty(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	tree.clear();

	// Assert
	assertNull(tree.pollLast());
    }

    @Test(dataProvider = "trees")
    public void pollLastShouldDecreaseSize(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int size = tree.size();

	// Act
	tree.pollLast();

	// Assert
	assertNotEquals(tree.size(), size);
    }
}
