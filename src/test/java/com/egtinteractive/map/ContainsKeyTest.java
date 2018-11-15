package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.list.Generator;

import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

public class ContainsKeyTest extends Generator {

    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);

    }

    @Test
    public void containsKey_shouldReturnTrue_ifMappingForKey() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	boolean result = map.containsKey(key);

	// Assert
	assertTrue(result);
    }
}
