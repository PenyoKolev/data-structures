package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertFalse;
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
public class ContainsTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void containsShouldReturnTrueIfPresent(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	int random = ThreadLocalRandom.current().nextInt(0, 100);
	tree.add(random);
	
	// Act
	boolean isPresent = tree.contains(random);
	
	//Assert
	assertTrue(isPresent);
    }
    
    @Test(dataProvider = "trees")
    public void containsShouldReturnFalseIfNotPresent(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	tree.remove(12);
	
	// Act
	boolean isPresent = tree.contains(12);
	
	//Assert
	assertFalse(isPresent);
    }
}
