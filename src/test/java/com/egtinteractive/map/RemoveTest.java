package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.testng.annotations.BeforeMethod;

public class RemoveTest extends Generator {
    GenericMap<Integer, String> map;

    @BeforeMethod
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);

    }

    @Test
    public void remove_shouldDeleteValue_associatedWithKey() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	map.remove(key);
	String expected = map.get(key);

	// Assert
	assertNull(expected);
    }

    @Test
    public void remove_shouldReturnValue() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	String expected = map.remove(key);

	// Assert
	assertEquals(value, expected);
    }
}
