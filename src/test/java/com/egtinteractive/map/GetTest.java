package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.list.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

public class GetTest extends Generator {

    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);

    }

    @Test
    public void get_shouldReturnValue_associateWithThisKey() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);

	// Act
	String expected = map.get(key);

	// Assert
	assertEquals(value, expected);

    }

    @Test
    public void get_shoulReturnNull_ifNotSuchKey() {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	map.remove(key);

	// Act
	String expected = map.get(key);

	// Assert
	assertNull(expected);

    }
}
