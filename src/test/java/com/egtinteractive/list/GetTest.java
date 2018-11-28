package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;
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
	/**
	 * If size = 1, index should be 0, but second parameter in nextInt should be
	 * strictly greater;
	 */
	int indexBound = (size == 1) ? 1 : size - 1;
	int index = ThreadLocalRandom.current().nextInt(0, indexBound);
	int element = ThreadLocalRandom.current().nextInt();
	list.add(index, element);

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
}
