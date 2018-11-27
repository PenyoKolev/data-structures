package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class AddTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void addShouldAddAtLastPosition(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int expectedElement = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(expectedElement);
	int element = list.get(list.size() - 1);

	// Assert
	assertEquals(element, expectedElement);
    }

    @Test(dataProvider = "lists")
    public void addShouldIncreaseSize(GenericList<Integer> list) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int expectedSize = list.size() + 1;
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(element);

	// Assert
	assertEquals(list.size(),  expectedSize);
    }
    
    @Test(dataProvider = "lists")
    public void addElementShouldBeAtIndexZeroIfListIsEmpty(GenericList<Integer> list) {
	// Arrange
	list.clear();
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	list.add(element);

	// Assert
	assertEquals(list.indexOf(element), 0);
    }
    
    
}