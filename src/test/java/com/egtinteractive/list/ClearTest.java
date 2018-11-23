package com.egtinteractive.list;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

@Test(groups = "list-tests")
public class ClearTest extends Generator {

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
    public void clear_shouldEmpty_list() {
	//Act
	aList.clear();
	int size = aList.size();
	
	//Assert
	assertEquals(size, 0);
    }

}
