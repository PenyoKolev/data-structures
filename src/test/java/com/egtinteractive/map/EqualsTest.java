package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeMethod;

public class EqualsTest extends Generator {

    GenericMap<Integer, String> map;
    GenericMap<Integer, String> map1;

    @BeforeMethod
    public void beforeMethod() {
	map = new GenericMap<>();
	map1 = new GenericMap<>();
	fillMapWithString(10, map);
	for (MapEntry<Integer, String> mapEntry : map) {
	    map1.put(mapEntry.getKey(), mapEntry.getValue());
	}
    }

    @Test
    public void equals_shouldReturnTrue_ifMapsAreEquals() {
	//Act
	boolean isEquals = map.equals(map1);
	
	//Assert
	assertTrue(isEquals);
    }
    
    @Test
    public void equals_shouldReturnFalse_ifMapsAreNotEquals() {
	//Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	
	//Act
	boolean isEquals = map.equals(map1);
	
	//Assert
	assertFalse(isEquals);
    }
}
