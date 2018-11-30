package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class GetTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void getShouldReturnElementAtIndex(GenericList<Integer> list) {
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
	list.set(index, element);

	// Act
	int result = list.get(index);

	// Assert
	assertEquals(result, element);
    }

    @Test(dataProvider = "lists", expectedExceptions = IndexOutOfBoundsException.class)
    public void getShouldThrowExceptionIfNonValidIndex(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);

	// Act
	list.get(-1);
    }
    
    @Test(dataProvider = "lists")
    public void getShouldReturnNullIfElementIsNull(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	list.add(0, null);

	// Assert
	assertNull(list.get(0));
    }
}
