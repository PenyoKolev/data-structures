package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertEquals;
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
public class HashCodeTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>(), new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void hashCodeShouldReturnSameCodeForEqualTrees(BinaryTree<Integer> tree, BinaryTree<Integer> tree1) {
	// Arrange
	fillTreeWithIntegers(tree);
	for (Integer integer : tree) {
	    tree1.add(integer);
	}

	// Act
	int hash = tree.hashCode();
	int hash1 = tree1.hashCode();

	// Assert
	assertEquals(hash, hash1);
    }
}
