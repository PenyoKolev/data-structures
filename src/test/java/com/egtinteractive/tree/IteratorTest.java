package com.egtinteractive.tree;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.binarytree.BinaryTree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

@Test(groups = "tree-tests")
public class IteratorTest extends Generator {

    @DataProvider(name = "trees")
    public Object[][] createData() {
	return new Object[][] { { new BinaryTree<>() } };
    }

    @Test(dataProvider = "trees")
    public void iteratorShouldIterateOverAllElements(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	ArrayList<Integer> list = new ArrayList<>();
	list.addAll(Arrays.asList(38, 13, 51, 10, 12, 40, 84, 25, 89, 37, 66, 95));

	// Act
	for (Integer integer : tree) {
	    list.remove(integer);
	}

	// Assert
	assertEquals(list.size(), 0);

    }

    @Test(dataProvider = "trees")
    public void iteratorRemoveShouldRemoveElement(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	Iterator<Integer> iterator = tree.iterator();

	// Act
	while (iterator.hasNext()) {
	    iterator.next();
	    iterator.remove();
	}

	// Assert
	assertEquals(tree.size(), 0);
    }

    @Test(dataProvider = "trees")
    public void iteratorHasNextShouldReturnFalseIfTreeIsEmpty(BinaryTree<Integer> tree) {
	// Arrange
	fillTreeWithIntegers(tree);
	tree.clear();
	Iterator<Integer> iterator = tree.iterator();

	// Act
	boolean result = iterator.hasNext();

	// Assert
	assertFalse(result);
    }
}
