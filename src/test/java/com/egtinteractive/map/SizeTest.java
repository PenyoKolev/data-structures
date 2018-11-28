package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

@Test(groups = "map-tests")
public class SizeTest extends Generator {
    
    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }
    
    @Test(dataProvider = "maps")
    public void sizeShouldReturnNumberOfMapEnries(Map<Integer, String> map) {
	//Act
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	
	//Assert
	assertEquals(map.size(), size);
    }
    
    @Test(dataProvider = "maps")
    public void sizeShouldReturnZeroIfMapIsEmpty(Map<Integer, String> map) {
	//Act
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	map.clear();
	
	//Assert
	assertEquals(map.size(), 0);
    }
}
