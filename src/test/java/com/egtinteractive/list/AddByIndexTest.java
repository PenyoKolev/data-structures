package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class AddByIndexTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void addByIndexShouldIncreaseSize(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int expectedSize = list.size() + 1;
	int expectedElement = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(expectedElement);
	int realSize = list.size();

	// Assert
	assertEquals(realSize, expectedSize);

    }

    @Test(dataProvider = "lists", expectedExceptions = IndexOutOfBoundsException.class)
    public void addByIndexShouldThrowExceptionIfNonValidIndex(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(-1, element);
    }

    @Test(dataProvider = "lists")
    public void addByIndexOldElementShouldBeAtIndexPlusOne(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int newElement = ThreadLocalRandom.current().nextInt();
	int index = ThreadLocalRandom.current().nextInt(0, size);
	int oldElement = list.get(index);

	// Act
	list.add(index, newElement);
	int expectedOldElement = list.get(index + 1);

	// Assert
	assertEquals(oldElement, expectedOldElement);
    }

    @Test(dataProvider = "lists")
    public void addByIndexEqualSizeShouldAddElementOnLastPosition(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(size, element);
	int expected = list.get(size);

	// Assert
	assertEquals(element, expected);
    }

    @Test(dataProvider = "lists")
    public void addByIndexEqualZeroShouldAddElementOnFirstPosition(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(0, element);
	int expected = list.get(0);

	// Assert
	assertEquals(element, expected);
    }

    @Test(dataProvider = "lists")
    public void addByIndexNull(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);

	// Act
	list.add(0, null);

	// Assert
	assertNull(list.get(0));
    }
    
    @Test(dataProvider = "lists")
    public void addByIndexShouldResizeIfSizeEqualArrayLength(GenericList<Integer> list) {
	// Arrange
	for (int i = 0; i < 10; i++) {
	    list.add(i);
	}

	// Act
	list.add(0, 10);
    }
}
