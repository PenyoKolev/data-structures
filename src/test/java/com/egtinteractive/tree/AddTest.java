package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
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
public class AddTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void addShouldAddElement(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int random = ThreadLocalRandom.current().nextInt(0, 100);

	// Act
	tree.add(random);

	// Assert
	assertTrue(tree.contains(random));

    }

    @Test(dataProvider = "trees")
    public void addShouldIncreaseSize(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int random = ThreadLocalRandom.current().nextInt(0, 100);
	int size = tree.size();

	// Act
	tree.add(random);

	// Assert
	assertNotEquals(size, tree.size());
    }

    @Test(dataProvider = "trees")
    public void addShouldNotIncreaseSizeIfElementAlreadyExist(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int size = tree.size();

	// Act
	tree.add(38);

	// Assert
	assertEquals(size, tree.size());
    }
}
