package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
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
	List<Integer> llist = new LinkedList<>();
	for (int i = 0; i < list.size(); i++) {
	    llist.add(list.get(i));
	}

	// Act
	for (Integer integer : list) {
	    llist.remove(integer);
	}

	// Assert
	assertEquals(llist.size(), 0);
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

    @Test(dataProvider = "lists", expectedExceptions = NoSuchElementException.class)
    public void iteratorNextShouldThrowExceprtionIfNoNextElement(GenericList<Integer> list) {
	// Arrange
	Iterator<Integer> iterator = list.iterator();

	// Act
	iterator.next();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void iteratorNextShouldThrowExceprtionIfRemoveInvokedWithoutNext() {
	// Arrange
	GenericList<Integer> list = new GenericLinkedList<>();
	Iterator<Integer> iterator = list.iterator();

	// Act
	iterator.remove();
    }

    @Test(dataProvider = "lists")
    public void iteratorRemoveShouldRemoveElementIfHeadOrOther(GenericList<Integer> list) {
	// Arrange
	list.add(0);
	list.add(1);
	Iterator<Integer> iterator = list.iterator();

	// Act
	iterator.next();
	iterator.next();
	iterator.remove();

	// Assert
	assertEquals(list.size(), 1);
    }
}
