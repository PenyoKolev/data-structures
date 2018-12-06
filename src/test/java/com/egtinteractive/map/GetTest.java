package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "map-tests")
public class GetTest extends Generator {

    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }

    @Test(dataProvider = "maps")
    public void getShouldReturnValueAssociateWithThisKey(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	String expected = map.get(key);

	// Assert
	assertEquals(value, expected);

    }

    @Test(dataProvider = "maps")
    public void getShoulReturnNullIfNotSuchKey(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	map.remove(key);

	// Act
	String expected = map.get(key);

	// Assert
	assertNull(expected);
    }
    
    @Test(dataProvider = "maps")
    public void getShoulReturnNullIfValueIsNull(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	map.put(key, null);

	// Act
	String expected = map.get(key);

	// Assert
	assertNull(expected);
    }
    
    @Test(dataProvider = "maps")
    public void getShoulReturnNullIfNoSuchEntry(Map<Integer, String> map) {
	// Assert
	assertNull(map.get(0));
    }
}
