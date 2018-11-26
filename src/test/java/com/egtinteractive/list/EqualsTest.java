package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeMethod;

public class EqualsTest extends Generator {

    GenericList<Integer> aList;
    GenericList<Integer> aList1;

    GenericList<Integer> lList;
    GenericList<Integer> lList1;

    @BeforeMethod
    public void beforeMethods() {
	aList = new GenericArrayList<Integer>();
	aList1 = new GenericArrayList<Integer>();
	for (int i = 0; i < 10; i++) {
	    int number = ThreadLocalRandom.current().nextInt(1, 100);
	    aList.add(number);
	    aList1.add(number);
	}
	lList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, lList);
	lList1 = new GenericArrayList<Integer>();
	for (Integer integer : lList) {
	    lList1.add(integer);
	}
    }

    @Test
    public void equals_shouldReturnTrue_ifArrayListsAreEquals() {
	// Act
	boolean isEquals = aList.equals(aList1);

	// Assert
	assertTrue(isEquals);
    }
    
    @Test
    public void equals_shouldReturnTrue_ifLinkedListsAreEquals() {
	// Act
	boolean isEquals = lList.equals(lList1);

	// Assert
	assertTrue(isEquals);
    }
    
    @Test
    public void equals_shouldReturnFalse_ifArrayListsAreNotEquals() {
	//Arrange
	aList.remove(0);
	
	// Act
	boolean isEquals = aList.equals(aList1);

	// Assert
	assertFalse(isEquals);
    }
    
    @Test
    public void equals_shouldReturnTrue_ifLinkedListsAreNotEquals() {
	//Arrange
	lList.remove(0);
	
	// Act
	boolean isEquals = lList.equals(lList1);

	// Assert
	assertFalse(isEquals);
    }
}
