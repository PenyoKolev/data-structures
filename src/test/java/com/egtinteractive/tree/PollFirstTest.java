package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

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

public class PollFirstTest extends Generator {

    Tree<Integer> tree;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	fillTreeWithIntegers(tree);
    }

    @Test
    public void pollFirst_shouldReturnSmallestElement() {
	//Act
	int smallest = tree.pollFirst();
	
	//Assert
	assertEquals(smallest, 10);
    }
    
    @Test
    public void pollFirst_shouldDeleteSmallestElement() {
	//Arrange
	int smallest = 10;
	
	//Act
	tree.pollFirst();
	
	//Assert
	assertFalse(tree.contains(smallest));
    }
    
    @Test
    public void pollFirst_shouldReturnNull_ifTreeIsEmpty() {
	//Arrange
	tree.clear();
	
	//Assert
	assertNull(tree.pollFirst());
    }
    
    @Test
    public void pollFirst_shouldDecreaseSize() {
	//Arrange
	int size = tree.size();
	
	//Act
	tree.pollFirst();
	
	//Assert
	assertNotEquals(tree.size(), size);
    }
}
