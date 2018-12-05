package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class RemoveValueTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void removeElementShouldReturnTrueIfRemoved(GenericList<String> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithStrings(size, list);
	String element = list.get(size - 1);
	// Act
	boolean result = list.remove(element);

	// Assert
	assertTrue(result);
    }

    @Test(dataProvider = "lists")
    public void removeElementFromFirstPosition(GenericList<String> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithStrings(size, list);
	String element = UUID.randomUUID().toString();
	list.set(0, element);

	// Act
	boolean result = list.remove(element);

	// Assert
	assertTrue(result);

    }

    @Test(dataProvider = "lists")
    public void removeElementFromLastPosition(GenericList<String> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithStrings(size, list);
	String element = UUID.randomUUID().toString();
	list.add(size, element);

	// Act
	boolean result = list.remove(element);

	// Assert
	assertTrue(result);
    }

    @Test(dataProvider = "lists")
    public void removeElementShouldDecreaseSize(GenericList<String> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithStrings(size, list);
	String element = list.get(size - 1);
	// Act
	list.remove(element);

	// Assert
	assertNotEquals(list.size(), size);

    }
}
