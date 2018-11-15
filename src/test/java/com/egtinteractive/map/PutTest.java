package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.egtinteractive.list.Generator;

@Test(groups = "map-tests")
public class PutTest extends Generator {
    
    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);
	
    }
    
    @Test
    public void put_shouldAssociateValue_withKey() {
	//Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	
	//Act
	map.put(key, value);
	String expected = map.get(key);
	
	//Assert
	assertEquals(value, expected);
    }
    
    @Test
    public void put_shouldReturnValue() {
	//Arrange
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	
	//Act
	String expected = map.put(key, value);
	
	//Assert
	assertEquals(value, expected);
    }
}
