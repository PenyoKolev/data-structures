package com.egtinteractive.list;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

public class HashCodeTest extends Generator {

    GenericList<Integer> aList;
    GenericList<Integer> aList1;

    GenericList<Integer> lList;
    GenericList<Integer> lList1;

    @BeforeClass
    public void beforeClass() {
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
    public void hashCode_shouldReturnSameCode_forEqualArrayList() {
	// Act
	int hash = aList.hashCode();
	int hash1 = aList1.hashCode();

	// Assert
	assertEquals(hash, hash1);
    }

    @Test
    public void hashCode_shouldReturnSameCode_forEqualLinkedList() {
	// Act
	int hash = lList.hashCode();
	int hash1 = lList1.hashCode();

	// Assert
	assertEquals(hash, hash1);
    }
}
