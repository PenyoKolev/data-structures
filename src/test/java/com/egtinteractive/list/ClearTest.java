package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class ClearTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void clearShouldEmptyList(GenericList<Integer> list) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	
	//Act
	list.clear();
	int ListSize = list.size();
	
	//Assert
	assertEquals(ListSize, 0);
    }

}
