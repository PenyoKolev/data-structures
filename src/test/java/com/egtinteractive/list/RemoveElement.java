package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class RemoveElement extends Generator {

    GenericList<Integer> aList;
    GenericList<Integer> lList;

    @BeforeClass
    public void beforeClass() {
	aList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, aList);
	lList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, lList);
    }

    @Test
    public void remove_shouldRemoveElement_andReturnTrue() {
	// Arrange
	boolean result = false;
	int index = ThreadLocalRandom.current().nextInt(0, 9);
	int element = aList.get(index);

	// Act
	result = aList.remove(element);

	// Assert
	assertTrue(result);
    }

}
