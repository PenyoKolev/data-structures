package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

public class SizeTest extends Generator {
    
    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);

    }

    @Test
    public void size_shouldReturn_numberOfMapEnries() {
	//Act
	int result = map.size();
	
	//Assert
	assertEquals(10, result);
    }
}
