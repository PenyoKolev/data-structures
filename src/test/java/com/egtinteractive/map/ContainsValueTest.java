package com.egtinteractive.map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

public class ContainsValueTest extends Generator {
    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);
    }

    @Test
    public void containsValue_shouldReturnTrue_ifValueMappedToKey() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	boolean result = map.containsValue(value);

	// Assert
	assertTrue(result);
    }
    
    @Test
    public void containsValue_shouldReturnFalse_ifValueNotMappedToKey() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	map.remove(key);

	// Act
	boolean result = map.containsValue(value);

	// Assert
	assertFalse(result);
    }
}
