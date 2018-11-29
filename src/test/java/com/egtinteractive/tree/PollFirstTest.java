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
public class PollFirstTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void pollFirstShouldReturnSmallestElement(BinaryTree<Integer> tree) {
	//Act
	fillTreeWithIntegers(tree);
	int smallest = tree.pollFirst();
	
	//Assert
	assertEquals(smallest, 10);
    }
    
    @Test(dataProvider = "trees")
    public void pollFirstShouldDeleteSmallestElement(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	int smallest = 10;
	
	//Act
	tree.pollFirst();
	
	//Assert
	assertFalse(tree.contains(smallest));
    }
    
    @Test(dataProvider = "trees")
    public void pollFirstShouldReturnNullIfTreeIsEmpty(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	tree.clear();
	
	//Assert
	assertNull(tree.pollFirst());
    }
    
    @Test(dataProvider = "trees")
    public void pollFirstShouldDecreaseSize(BinaryTree<Integer> tree) {
	//Arrange
	fillTreeWithIntegers(tree);
	int size = tree.size();
	
	//Act
	tree.pollFirst();
	
	//Assert
	assertNotEquals(tree.size(), size);
    }
}
