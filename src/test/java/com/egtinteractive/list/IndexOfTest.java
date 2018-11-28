package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@Test(groups = "list-tests")
public class IndexOfTest extends Generator {
    
    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericArrayList<>() }, { new GenericLinkedList<>() }, };
    }

    @Test(dataProvider = "lists")
    public void indexOfShouldReturnFirstElement(GenericList<Integer> list) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	int element = ThreadLocalRandom.current().nextInt();
	int index;
	/**
	 * If size = 1, index should be 0, but second parameter in nextInt should be
	 * strictly greater;
	 */
	if (size == 1) {
	    index = 0;
	} else {
	    index = ThreadLocalRandom.current().nextInt(0, size - 1);
	}
	list.set(index, element);
	
	//Act
	int result = list.indexOf(element);
	
	//Assert
	assertEquals(index, result);
    }
    
    @Test(dataProvider = "lists")
    public void indexOfShouldReturnMinusOneIfNotFound(GenericList<Integer> list) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillListWithIntegers(size, list);
	
	//Act
	int result = list.indexOf(-1);
	int expected = -1;
	
	//Assert
	assertEquals(expected, result);
	
    }
}
