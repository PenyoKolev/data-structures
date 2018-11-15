package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class ContainsTest extends Generator {
    
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
    public void contains_shouldReturnTrue_ifElementFound() {
	//Arrange
	int element = ThreadLocalRandom.current().nextInt();
	aList.add(element);
	boolean result;
	
	//Act
	result = aList.contains(element);
	
	//Assert
	assertTrue(result);
    }

    @Test
    public void contains_shouldReturnFalse_ifElementNotFound() {
	//Arrange
	int index = ThreadLocalRandom.current().nextInt(0 ,9);
	int element = aList.get(index);
	aList.remove(index);
	boolean result;
	
	//Act
	result = aList.contains(element);
	
	//Assert
	assertFalse(result);
    }
}
