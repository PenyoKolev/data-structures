package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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
    
    @Test(dataProvider = "maps")
    public void removeShouldReturnNullIfValueIsNull(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	map.put(key, null);
	
	//Act
	String result = map.remove(key);
	
	// Assert
	assertEquals(result, null);
    }
    
    @Test(dataProvider = "maps")
    public void removeShouldReturnValueIfKeyIsNull(Map<Integer, String> map) {
	// Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	String value = UUID.randomUUID().toString();
	map.put(null, value);
	
	//Act
	String result = map.remove(null);
	
	// Assert
	assertEquals(result, value);
    }
    
    @Test(dataProvider = "maps")
    public void removeShouldReturnNullIfNodeIsNull(Map<Integer, String> map) {
	// Assert
	assertNull(map.remove(0));
    }
}
