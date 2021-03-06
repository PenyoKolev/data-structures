package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class HashCodeTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>(), new GenericArrayList<>() },
		{ new GenericLinkedList<>(), new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void hashCodeShouldReturnSameCodeForEqualLists(GenericList<Integer> list, GenericList<Integer> list1) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	for (Integer integer : list) {
	    list1.add(integer);
	}

	// Act
	int hash = list.hashCode();
	int hash1 = list1.hashCode();

	// Assert
	assertEquals(hash, hash1);
    }
}
