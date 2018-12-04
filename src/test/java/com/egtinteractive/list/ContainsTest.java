package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class ContainsTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void containsShouldReturnTrueIfElementFound(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();
	list.add(element);

	// Assert
	assertTrue(list.contains(element));
    }

    /*
     * [WARNING] author ivailozd
     * 
     * Can fail in some cases!
     * 
     */
    @Test(dataProvider = "lists")
    public void containsShouldReturnFalseIfElementNotFound(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();

	// Assert
	assertFalse(list.contains(element));
    }

    @Test(dataProvider = "lists")
    public void containsShouldReturnTrueIfNullElementFound(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	list.add(null);

	// Assert
	assertTrue(list.contains(null));
    }
}
