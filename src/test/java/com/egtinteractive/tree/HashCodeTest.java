package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;
import com.egtinteractive.binarytree.Tree;

import static org.testng.Assert.assertEquals;

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

public class HashCodeTest extends Generator {

    Tree<Integer> tree;
    Tree<Integer> tree1;

    @BeforeMethod
    public void beforeClass() {
	tree = new BinaryTree<>();
	tree1 = new BinaryTree<>();
	fillTreeWithIntegers(tree);
	for (Integer integer : tree) {
	    tree1.add(integer);
	}
    }

    @Test
    public void hashCode_shouldReturnSameCode_forEqualTrees() {
	// Act
	int hash = tree.hashCode();
	int hash1 = tree1.hashCode();

	// Assert
	assertEquals(hash, hash1);
    }
}
