package com.egtinteractive.list;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

@Test(groups = "list-tests")
public class SizeTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void sizeShouldReturnNumberOfElements(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int numberOfElements = 0;
	for (Integer integer : list) {
	    numberOfElements++;
	}

	// Act
	int expectedSize = list.size();

	// Assert
	assertEquals(expectedSize, numberOfElements);
    }

    @Test(dataProvider = "lists")
    public void sizeShouldReturnZeroIfListIsEmpty(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	list.clear();

	// Act
	int expectedSize = list.size();

	// Assert
	assertEquals(expectedSize, 0);
    }
}
