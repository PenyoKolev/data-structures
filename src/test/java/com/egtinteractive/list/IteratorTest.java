package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class IteratorTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void iteratorShouldIterateOverAllElementsOnList(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int iteration = 0;

	// Act
	for (Integer integer : list) {
	    iteration++;
	}

	// Assert
	assertEquals(iteration, size);
    }

    @Test(dataProvider = "lists")
    public void iteratorRemoveShouldRemoveElement(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	Iterator<Integer> iterator = list.iterator();

	// Act
	while (iterator.hasNext()) {
	    iterator.next();
	    iterator.remove();
	}

	// Assert
	assertEquals(list.size(), 0);
    }
    
    @Test(dataProvider = "lists")
    public void iteratorHasNextShouldReturnFalseIfListIsEmpty(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	list.clear();
	Iterator<Integer> iterator = list.iterator();

	// Act
	boolean result = iterator.hasNext();

	// Assert
	assertFalse(result);
    }
}
