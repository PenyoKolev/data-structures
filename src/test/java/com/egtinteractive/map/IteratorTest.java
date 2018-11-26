package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

public class IteratorTest extends Generator {

    GenericMap<Integer, String> map;

    @BeforeMethod
    public void beforeMethod() {
	map = new GenericMap<>();
	fillMapWithString(10, map);
    }

    @Test
    public void iterator_shouldIterateOverAllElements() {
	int size = map.size();
	int iteration = 0;

	// Act
	for (MapEntry<Integer, String> string : map) {
	    iteration++;
	}

	// Assert
	assertEquals(iteration, size);
    }
}
