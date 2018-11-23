package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class SetTest extends Generator {

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
    public void set_shouldReplaceOldElement() {
	// Arrange
	int element = ThreadLocalRandom.current().nextInt();
	int index = ThreadLocalRandom.current().nextInt(0, 9);

	// Act
	aList.set(index, element);
	int result = aList.get(index);

	// Assert
	assertEquals(result, element);
    }
    
    @Test
    public void set_shouldNot_increaseSize() {
	// Arrange
	int expectedSize = aList.size();
	int index = ThreadLocalRandom.current().nextInt(0, 9);
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	aList.set(index, element);
	int size = aList.size();

	// Assert
	assertEquals(size, expectedSize);

    }
    
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void set_shouldThrowException_ifNonValidIndex() {
	// Arrange
	int element = ThreadLocalRandom.current().nextInt();

	// Act
	aList.set(-1, element);
    }

}
