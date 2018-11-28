package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

public class EqualsTest extends Generator {
    
    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>(), new GenericArrayList<>() }, { new GenericLinkedList<>(), new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void equalsShouldReturnTrueIfListsAreEquals(GenericList<Integer> list, GenericList<Integer> list1) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	for (Integer integer : list) {
	    list1.add(integer);
	}
	
	// Act
	boolean equals = list.equals(list1);
	
	// Assert
	assertTrue(equals);
    }

    @Test(dataProvider = "lists")
    public void equalsShouldReturnFalseIfListsAreNotEquals(GenericList<Integer> list, GenericList<Integer> list1) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	for (Integer integer : list) {
	    list1.add(integer);
	}
	list.add(ThreadLocalRandom.current().nextInt());
	
	// Act
	boolean equals = list.equals(list1);

	// Assert
	assertFalse(equals);
    }
    
    @Test(dataProvider = "lists")
    public void equalsShouldReturnTrueIfBothListsAreEmpty(GenericList<Integer> list, GenericList<Integer> list1) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int size1 = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size1, list1);
	list.clear();
	list1.clear();
	
	// Act
	boolean equals = list.equals(list1);

	// Assert
	assertTrue(equals);
    }
}
