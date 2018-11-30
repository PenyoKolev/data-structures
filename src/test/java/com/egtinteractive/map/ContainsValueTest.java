package com.egtinteractive.map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

@Test(groups = "map-tests")
public class ContainsValueTest extends Generator {

    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }

    @Test(dataProvider = "maps")
    public void containsValueShouldReturnTrueIfSuchValue(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	boolean result = map.containsValue(value);

	// Assert
	assertTrue(result);
    }

    @Test(dataProvider = "maps")
    public void containsValueShouldReturnFalseIfNoSuchValue(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	map.remove(key);

	// Act
	boolean result = map.containsValue(value);

	// Assert
	assertFalse(result);
    }
    
    @Test(dataProvider = "maps")
    public void containsValueShouldReturnTrueIfNullValue(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	map.put(key, null);

	// Act
	boolean result = map.containsValue(null);

	// Assert
	assertTrue(result);
    }
}
