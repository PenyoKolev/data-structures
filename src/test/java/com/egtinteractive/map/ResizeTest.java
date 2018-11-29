package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

@Test(groups = "map-tests")
public class ResizeTest extends Generator {

    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }

    @Test(dataProvider = "maps")
    public void resizeShouldKeepKeysUnchanged(Map<Integer, String> map) {
	// Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	fillMapWithString(ThreadLocalRandom.current().nextInt(10, 100), map);

	// Act
	map.put(ThreadLocalRandom.current().nextInt(), UUID.randomUUID().toString());

	// Assert
	assertEquals(value, map.get(key));
    }
}
