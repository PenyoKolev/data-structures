package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
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

public class AddTest extends Generator {


    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void add_shouldAddElement() {
	// Arrange
	int random = ThreadLocalRandom.current().nextInt(0, 100);

	// Act
	tree.add(random);

	// Assert
	assertTrue(tree.contains(random));

    }

    @Test
    public void add_shouldIncreaseSize() {
	// Arrange
	int random = ThreadLocalRandom.current().nextInt(0, 100);
	int size = tree.size();

	// Act
	tree.add(random);

	// Assert
	assertNotEquals(size, tree.size());
    }

    @Test
    public void add_shouldNotIncreaseSize_ifElementAlreadyExist() {
	// Arrange
	int size = tree.size();

	// Act
	tree.add(38);

	// Assert
	assertEquals(size, tree.size());
    }
}
