package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

@Test(groups = "list-tests")
public class SizeTest extends Generator {

    GenericList<Integer> aList;
    GenericList<Integer> lList;

    @Test
    public void size_shouldReturn_numberOfElements() {
	// Arrange
	aList = new GenericArrayList<Integer>();
	int size = ThreadLocalRandom.current().nextInt(0, 100);
	fillListWithIntegers(size, aList);

	// Act
	int expectedSize = aList.size();

	// Assert
	assertEquals(size, expectedSize);
    }

    @Test
    public void size_shouldReturnZero_ifListIsEmpty() {
	// Arrange
	aList = new GenericArrayList<Integer>();
	int size = ThreadLocalRandom.current().nextInt(0, 100);
	fillListWithIntegers(size, aList);
	aList.clear();

	// Act
	int expectedSize = aList.size();

	// Assert
	assertEquals(0, expectedSize);
    }
}
