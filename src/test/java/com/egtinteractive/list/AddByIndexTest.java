package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class AddByIndexTest extends Generator {

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
    public void addByIndex_shouldIncreaseSize() {
	// Arrange
	int expectedSize = aList.size() + 1;
	int expectedElement = ThreadLocalRandom.current().nextInt();

	// Act
	aList.add(expectedElement);
	int size = aList.size();

	// Assert
	assertEquals(size, expectedSize);

    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void addByIndex_shouldThrowException_ifNonValidIndex() {
	// Arrange
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	aList.add(-1, element);
    }
    
    @Test
    public void addByIndex_oldElement_shouldBeAtIndex_plusOne() {
	//Arrange
	int newElement = ThreadLocalRandom.current().nextInt();
	int index = ThreadLocalRandom.current().nextInt(0, 9);
	int oldElement = aList.get(index);
	
	//Act
	aList.add(index, newElement);
	int expectedOldElement = aList.get(index + 1);
	
	//Assert
	assertEquals(oldElement, expectedOldElement);
    }
    
    
}
