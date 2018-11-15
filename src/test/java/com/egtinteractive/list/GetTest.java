package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class GetTest extends Generator {

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
    public void get_shouldReturn_elementAtIndex() {
	//Arrange
	for (int i = 0; i < aList.size(); i++) {
	    aList.set(i, i);
	}
	
	//Act
	int index = ThreadLocalRandom.current().nextInt(0, 9);
	int result = aList.get(index);
	
	//Assert
	assertEquals(index, result);
    }
    
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void get_shouldThrowException_ifNonValidIndex() {
	// Act
	aList.get(-1);
    }
    
    
}
