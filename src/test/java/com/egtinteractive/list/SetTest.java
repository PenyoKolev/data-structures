package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class SetTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void setShouldReplaceOldElement(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();
	int index;
	/**
	 * If size = 1, index should be 0, but second parameter in nextInt should be
	 * strictly greater;
	 */
	if (size == 1) {
	    index = 0;
	} else {
	    index = ThreadLocalRandom.current().nextInt(0, size - 1);
	}
	
	// Act
	list.set(index, element);
	int result = list.get(index);

	// Assert
	assertEquals(result, element);
    }
    
    @Test(dataProvider = "lists")
    public void setShouldNotIncreaseSize(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();
	int index;
	/**
	 * If size = 1, index should be 0, but second parameter in nextInt should be
	 * strictly greater;
	 */
	if (size == 1) {
	    index = 0;
	} else {
	    index = ThreadLocalRandom.current().nextInt(0, size - 1);
	}
	int expectedSize = list.size();
	
	// Act
	list.set(index, element);
	int ListSize = list.size();

	// Assert
	assertEquals(ListSize, expectedSize);

    }
    
    @Test(dataProvider = "lists", expectedExceptions = IndexOutOfBoundsException.class)
    public void setShouldThrowExceptionIfNonValidIndex(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	list.set(-1, element);
    }

    @Test(dataProvider = "lists")
    public void setNullShouldReplaceOldElementWithNull(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int index;
	/**
	 * If size = 1, index should be 0, but second parameter in nextInt should be
	 * strictly greater;
	 */
	if (size == 1) {
	    index = 0;
	} else {
	    index = ThreadLocalRandom.current().nextInt(0, size - 1);
	}
	
	// Act
	list.set(index, null);

	// Assert
	assertEquals(list.get(index), null);
    }
}
