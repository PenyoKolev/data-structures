package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.list.Generator;

import static org.testng.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeClass;

public class ResizeTest extends Generator{
    
    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);
    }
    
    @Test
    public void resize_shouldKeepKeys_unchanged() {
	//Arrange
	int key = ThreadLocalRandom.current().nextInt(0, 10);
	String value = map.get(key);
	
	//Act
	map.put(ThreadLocalRandom.current().nextInt(), UUID.randomUUID().toString());
	
	//Assert
	assertEquals(value, map.get(key));
    }
}
