package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;

public class IteratorTest extends Generator {

    GenericList<Integer> aList;
    GenericList<Integer> lList;

    @BeforeMethod
    public void beforeClass() {
	aList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, aList);
	lList = new GenericArrayList<Integer>();
	fillListWithIntegers(10, lList);
    }

    @Test
    public void iterator_shouldIterateOverAllElements_onArrayList() {
	//Arrange
	int size = aList.size();
	int iteration = 0;
	
	//Act
	for (Integer integer : aList) {
	    iteration++;
	}
	
	//Assert
	assertEquals(iteration, size);
	
    }
    
    @Test
    public void iterator_shouldIterateOverAllElements_onLinkedList() {
	//Arrange
	int size = lList.size();
	int iteration = 0;
	
	//Act
	for (Integer integer : lList) {
	    iteration++;
	}
	
	//Assert
	assertEquals(iteration, size);
	
    }
}
