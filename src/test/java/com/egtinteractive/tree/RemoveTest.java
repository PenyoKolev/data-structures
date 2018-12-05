package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
 *			       /	  \
 *			      30	  95
 */

@Test(groups = "tree-tests")
public class RemoveTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void removeLeafNodeShouldDeleteNode(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	int leaf = 12;
	
	//Act
	tree.remove(leaf);
	
	//Assert
	assertFalse(tree.contains(leaf));
    }
    
    @Test(dataProvider = "trees")
    public void removeNodeWithOneRightChildShouldDeleteNode(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	tree.add(30);
	int node = 37;
	
	//Act
	tree.remove(node);
	int lower = tree.lower(38);
	
	//Assert
	assertEquals(lower, 30);
    }
    
    @Test(dataProvider = "trees")
    public void removeNodeWithOneLeftChildShouldDeleteNode(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	int node = 10;
	
	//Act
	tree.remove(node);
	
	//Assert
	assertNull(tree.lower(12));
    }
    
    @Test(dataProvider = "trees")
    public void removeNodeWithTwoChildShouldDeleteNode(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	int node = 38;
	
	//Act
	tree.remove(node);
	int lower = tree.lower(51);
	
	//Assert
	assertEquals(lower, 40);
    }
}
