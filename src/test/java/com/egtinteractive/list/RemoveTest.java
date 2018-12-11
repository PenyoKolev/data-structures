package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class RemoveTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void removeShouldReturnTrueIfRemoved(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = list.get(ThreadLocalRandom.current().nextInt(0, size));

	// Act
	boolean result = list.remove(list.indexOf(element));

	// Assert
	assertTrue(result);

    }

    @Test(dataProvider = "lists")
    public void removeFromFirstPosition(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(2, 100);
	for (int i = 0; i < size; i++) {
	    list.add(i);
	}
	int element = list.get(0);

	// Act
	list.remove(0);

	// Assert
	assertFalse(list.get(0).equals(element));

    }

    @Test(dataProvider = "lists")
    public void removeFromLastPosition(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt(100, 1000);
	list.add(element);

	// Act
	list.remove(list.size() - 1);

	// Assert
	assertTrue(list.remove(list.size() - 1));
    }

    @Test(dataProvider = "lists")
    public void removeShouldDecreaseSize(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);

	// Act
	list.remove(ThreadLocalRandom.current().nextInt(0, size));

	// Assert
	assertNotEquals(list.size(), size);

    }

    @Test(dataProvider = "lists")
    public void removeShouldRemoveNullValue(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	list.add(null);
	int listSize = list.size();

	// Act
	list.remove(null);

	// Assert
	assertNotEquals(list.size(), listSize);
    }

    @Test(dataProvider = "lists", expectedExceptions = IndexOutOfBoundsException.class)
    public void removeShouldThrowExceptionIfNoSuchIndex(GenericList<Integer> list) {
	// Act
	list.remove(1);
    }
}
