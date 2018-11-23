package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

public class ClearTest extends Generator {
    
    GenericMap<Integer, String> map;

    @BeforeClass
    public void beforeClass() {
	map = new GenericMap<>();
	fillMapWithString(10, map);

    }

    @Test
    public void clear_shouldEmpty_map() {
	//Act
	map.clear();
	int size = map.size();
	
	//Assert
	assertEquals(0, size);
    }
}
