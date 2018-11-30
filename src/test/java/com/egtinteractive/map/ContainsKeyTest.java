package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "map-tests")
public class ContainsKeyTest extends Generator {

    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }
    
    @Test(dataProvider = "maps")
    public void containsKeyShouldReturnTrueIfMappingForKey(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	
	// Act
	boolean result = map.containsKey(key);

	// Assert
	assertTrue(result);
    }
    
    @Test(dataProvider = "maps")
    public void containsKeyShouldReturnFalseIfNoMappingForKey(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	map.remove(key);
	
	// Act
	boolean result = map.containsKey(key);

	// Assert
	assertFalse(result);
    }
    
    @Test(dataProvider = "maps")
    public void containsKeyShouldReturnTrueIfNullKey(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	String value = UUID.randomUUID().toString();
	map.put(null, value);
	
	// Act
	boolean result = map.containsKey(null);

	// Assert
	assertTrue(result);
    }
}
