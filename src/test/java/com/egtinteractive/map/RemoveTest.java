package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.testng.annotations.DataProvider;

@Test(groups = "map-tests")
public class RemoveTest extends Generator {
    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }
    
    @Test(dataProvider = "maps")
    public void removeShouldDeleteValueAssociatedWithKey(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	
	//Act
	
	//Assert
    }

    @Test(dataProvider = "maps")
    public void removeShouldReturnValue(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	
	//Act
	String result = map.remove(key);
	
	// Assert
	assertEquals(result, value);
	
    }
}
