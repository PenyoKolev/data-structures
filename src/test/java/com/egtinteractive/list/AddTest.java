package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class AddTest extends Generator {

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
    public void add_shouldAddAtLastPosition() {
	// Arrange
	int expectedElement = ThreadLocalRandom.current().nextInt();

	// Act
	aList.add(expectedElement);
	int element = aList.get(aList.size() - 1);

	// Assert
	assertEquals(element, expectedElement);
    }

    @Test
    public void add_shouldIncreaseSize() {
	// Arrange
	int expectedSize = aList.size() + 1;
	int expectedElement = ThreadLocalRandom.current().nextInt();

	// Act
	aList.add(expectedElement);	
	int size = aList.size();

	// Assert
	assertEquals(size, expectedSize);

    }
    
    
    
}