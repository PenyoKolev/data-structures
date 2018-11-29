package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.map.GenericMap.Node;


@Test(groups = "map-tests")
public class IteratorTest extends Generator {
    
    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }
    
    @Test(dataProvider = "maps")
    public void iteratorShouldIterateOverAllElementsOnMap(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int iteration = 0;

	//Act
	for (Node<Integer, String> node : map) {
	    iteration++;
	}
	
	//Assert
	assertEquals(iteration, size);

    }
    
    @Test(dataProvider = "maps")
    public void iteratorRemoveShouldRemoveElement(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	Iterator<Node<Integer, String>> iterator = map.iterator();

	//Act
	while (iterator.hasNext()) {
	    iterator.next();
	    iterator.remove();
	}

	// Assert
	assertEquals(map.size(), 0);
    }
    
    @Test(dataProvider = "maps")
    public void iteratorHasNextShouldReturnFalseIfMapIsEmpty(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	map.clear();
	Iterator<Node<Integer, String>> iterator = map.iterator();

	// Act
	boolean result = iterator.hasNext();

	// Assert
	assertFalse(result);
    }
}
