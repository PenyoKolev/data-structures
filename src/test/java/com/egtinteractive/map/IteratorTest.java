package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
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
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	Set<Integer> keySet = new TreeSet<>();
	fillMapWithStringAndKeepKeySet(size, map, keySet);

	// Act
	for (Node<Integer, String> node : map) {
	    keySet.remove(node.getKey());
	}

	// Assert
	assertEquals(keySet.size(), 0);
    }

    @Test(dataProvider = "maps")
    public void iteratorRemoveShouldRemoveElement(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	Iterator<Node<Integer, String>> iterator = map.iterator();

	// Act
	while (iterator.hasNext()) {
	    iterator.next();
	    iterator.remove();
	}

	// Assert
	assertEquals(map.size(), 0);
    }

    @Test(dataProvider = "maps")
    public void iteratorHasNextShouldReturnFalseIfMapIsEmpty(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	map.clear();
	Iterator<Node<Integer, String>> iterator = map.iterator();

	// Act
	boolean result = iterator.hasNext();

	// Assert
	assertFalse(result);
    }

    @Test(dataProvider = "maps")
    public void iteratorNextShouldReturnNullIfMapIsEmpty(Map<Integer, String> map) {
	// Arrange
	map.put(1, "a");
	Iterator<Node<Integer, String>> iterator = map.iterator();
	iterator.next();

	// Assert
	assertNull(iterator.next());
    }
}
