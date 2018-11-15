package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class IndexOfTest extends Generator {
    
    GenericList<Integer> aList;
    GenericList<Integer> lList;

    @BeforeClass
    public void beforeClass() {
	aList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, aList);
	lList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, lList);
    }

    @Test
    public void indexOf_shouldReturn_firstElement() {
	//Arrange
	int element = ThreadLocalRandom.current().nextInt();
	int index = ThreadLocalRandom.current().nextInt(0, 9);
	aList.set(index, element);
	
	//Act
	int result = aList.indexOf(element);
	
	//Assert
	assertEquals(index, result);
    }
    
    @Test
    public void indexOf_shouldReturnMinusOne_ifNotFound() {	
	//Act
	int result = aList.indexOf(-2);
	int expected = -1;
	
	//Assert
	assertEquals(expected, result);
	
    }
}
