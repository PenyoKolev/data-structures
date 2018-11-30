package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

@Test(groups = "map-tests")
public class PutTest extends Generator {
    
    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }
    
    @Test(dataProvider = "maps")
    public void putShouldAssociateValueWithKey(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	
	//Act
	map.put(key, value);
	String expected = map.get(key);
	
	//Assert
	assertEquals(value, expected);
    }
    
    @Test(dataProvider = "maps")
    public void putShouldReturnValue(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	
	//Act
	String expected = map.put(key, value);
	
	//Assert
	assertEquals(value, expected);
    }
    
    @Test(dataProvider = "maps")
    public void putWithKeyNull(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	String value = UUID.randomUUID().toString();
	
	//Act
	String expected = map.put(null, value);
	
	//Assert
	assertEquals(value, expected);
    }
    
    @Test(dataProvider = "maps")
    public void putWithValueNull(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	int key = ThreadLocalRandom.current().nextInt();
	
	//Act
	String expected = map.put(key, null);
	
	//Assert
	assertEquals(null, expected);
    }
}
