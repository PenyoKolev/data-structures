package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertFalse;
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

public class ContainsTest extends Generator {

    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void contains_shouldReturnTrue_ifPresent() {
	// Arrange
	int random = ThreadLocalRandom.current().nextInt(0, 100);
	tree.add(random);
	
	// Act
	boolean isPresent = tree.contains(random);
	
	//Assert
	assertTrue(isPresent);
    }
    
    @Test
    public void contains_shouldReturnFalse_ifNotPresent() {
	// Arrange
	tree.remove(12);
	
	// Act
	boolean isPresent = tree.contains(12);
	
	//Assert
	assertFalse(isPresent);
    }
}
